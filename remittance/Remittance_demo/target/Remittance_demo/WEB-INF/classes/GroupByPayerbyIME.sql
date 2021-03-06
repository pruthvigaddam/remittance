SELECT
	CASE
		WHEN
			BTF.TRANS_TYPE_CD	=	?
		AND	BTF.DR_CR_FLAG		=	1
		THEN
			(BTF.TENDERED_AMOUNT*1)
		ELSE
			CASE
				WHEN
					BTF.TRANS_TYPE_CD	=	?
				AND	BTF.DR_CR_FLAG		=	2
				THEN
					(BTF.TENDERED_AMOUNT*-1)
			END
	END
						AS	PAYMENTAMOUNT
,	CASE
		WHEN
			BTF.TRANS_TYPE_CD	=	?
		AND	BTF.DR_CR_FLAG		=	1
		THEN
			(BTF.TRANS_TOTAL_AMOUNT*1)
		ELSE
			CASE
				WHEN
					BTF.TRANS_TYPE_CD	=	?
				AND	BTF.DR_CR_FLAG		=	2
				THEN
					(BTF.TRANS_TOTAL_AMOUNT*-1)
			END
	END					AS	ADJUSTAMOUNT
,	O.ORGANIZATION_ID	AS	ID
,	O.ORG_NAME			AS	NAME
FROM
	BATCH_TRANS_FILE	BTF
JOIN
	BILL_REC	BR
ON
	BR.CORSP_ACTIVITY_ID	=	BTF.CORSP_ACTIVITY_ID
AND	BR.BILL_TYPE_CD			IN	(?, ?)
AND	BR.ACTIVE_IND			=	1
JOIN
	BILL_RELTN	BRN
ON
	BRN.CORSP_ACTIVITY_ID	=	BTF.CORSP_ACTIVITY_ID
AND	BRN.BILL_VRSN_NBR		=	BR.BILL_VRSN_NBR
AND	BRN.PARENT_ENTITY_NAME	=	'BO_HP_RELTN'
AND	BRN.ACTIVE_IND			=	1
AND	BRN.BEG_EFFECTIVE_DT_TM	<=	?
AND	BRN.END_EFFECTIVE_DT_TM	>	?
JOIN
	BO_HP_RELTN	BHR
ON
	BHR.BO_HP_RELTN_ID	=	BRN.PARENT_ENTITY_ID
AND	BHR.ACTIVE_IND		=	1
AND	BHR.FIN_CLASS_CD	!=	?
JOIN
	ORGANIZATION	O
ON
	O.ORGANIZATION_ID	=	BTF.PAYOR_ORG_ID
AND	O.ACTIVE_IND		=	1
WHERE
	BTF.BATCH_TRANS_ID		=	?
AND	BTF.ACTIVE_IND			=	1
AND	BTF.CORSP_ACTIVITY_ID	!=	0.0
AND	BTF.NONTRANS_FLAG		=	0
AND	BTF.DR_CR_FLAG			=	?
GROUP BY
	O.ORGANIZATION_ID
,	O.ORG_NAME
,	BTF.TENDERED_AMOUNT
,	BTF.TRANS_TYPE_CD
,	BTF.DR_CR_FLAG
,	BTF.TRANS_TOTAL_AMOUNT
UNION
SELECT
	CASE
		WHEN
			BTF.TRANS_TYPE_CD	=	?
		AND	BTF.DR_CR_FLAG		=	1
		THEN
			(BTF.TENDERED_AMOUNT*1)
		ELSE
			CASE
				WHEN
					BTF.TRANS_TYPE_CD	=	?
				AND	BTF.DR_CR_FLAG		=	2
				THEN
					(BTF.TENDERED_AMOUNT*-1)
			END
	END
						AS	PAYMENTAMOUNT
,	CASE
		WHEN
			BTF.TRANS_TYPE_CD	=	?
		AND	BTF.DR_CR_FLAG		=	1
		THEN
			(BTF.TRANS_TOTAL_AMOUNT*1)
		ELSE
			CASE
				WHEN
					BTF.TRANS_TYPE_CD	=	?
				AND	BTF.DR_CR_FLAG		=	2
				THEN
					(BTF.TRANS_TOTAL_AMOUNT*-1)
			END
	END					AS	ADJUSTAMOUNT
,	O.ORGANIZATION_ID	AS	ID
,	O.ORG_NAME			AS	NAME
FROM
	BATCH_TRANS_FILE	BTF
JOIN
	BATCH_TRANS_FILE	BTF2
ON
	BTF2.BATCH_TRANS_ID			=	BTF.BATCH_TRANS_ID
AND	BTF2.ACTIVE_IND				=	1
AND	BTF2.AR_ACCOUNT_ID			!=	0.0
AND	BTF2.RELATED_SEQ_NBR		=	BTF.SEQUENCE_NBR
AND	BTF2.BATCH_TRANS_FILE_ID	!=	BTF.BATCH_TRANS_FILE_ID
JOIN
	BILL_REC	BR
ON
	BR.CORSP_ACTIVITY_ID	=	BTF.CORSP_ACTIVITY_ID
AND	BR.BILL_TYPE_CD			IN	(?, ?)
AND	BR.ACTIVE_IND			=	1
JOIN
	BILL_RELTN	BRN
ON
	BRN.CORSP_ACTIVITY_ID	=	BTF.CORSP_ACTIVITY_ID
AND	BRN.BILL_VRSN_NBR		=	BR.BILL_VRSN_NBR
AND	BRN.PARENT_ENTITY_NAME	=	'BO_HP_RELTN'
AND	BRN.ACTIVE_IND			=	1
AND	BRN.BEG_EFFECTIVE_DT_TM	<=	?
AND	BRN.END_EFFECTIVE_DT_TM	>	?
JOIN
	BO_HP_RELTN	BHR
ON
	BHR.BO_HP_RELTN_ID	=	BRN.PARENT_ENTITY_ID
AND	BHR.ACTIVE_IND		=	0
AND	BHR.RELTN_TYPE_CD	=	?
AND	BHR.FIN_CLASS_CD	!=	?
JOIN
	ORGANIZATION	O
ON
	O.ORGANIZATION_ID	=	BTF.PAYOR_ORG_ID
AND	O.ACTIVE_IND		=	1
WHERE
	BTF.BATCH_TRANS_ID		=	?
AND	BTF.ACTIVE_IND			=	1
AND	BTF.CORSP_ACTIVITY_ID	!=	0.0
AND	BTF.DR_CR_FLAG			=	?
GROUP BY
	O.ORG_NAME
,	O.ORGANIZATION_ID
,	BTF.TENDERED_AMOUNT
,	BTF.TRANS_TYPE_CD
,	BTF.DR_CR_FLAG
,	BTF.TRANS_TOTAL_AMOUNT
