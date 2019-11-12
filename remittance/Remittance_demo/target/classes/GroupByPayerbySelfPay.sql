select 
CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.tendered_amount*1) else
       CASE  WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.tendered_amount*-1)
         end
   
   END as paymentamount
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
	END
	AS	ADJUSTAMOUNT
   ,'SELF_PAY' as name
   from batch_trans_file btf
   join bill_rec br on  br.corsp_activity_id    = btf.corsp_activity_id
              and br.bill_class_cd        = ?
              and br.active_ind           = 1
       
    where btf.batch_trans_id      = ?
              and btf.active_ind          = 1
              and btf.nontrans_flag       = 0
              and btf.corsp_activity_id   > 0.0
              and btf.dr_cr_flag          =?
    group by btf.TENDERED_AMOUNT, btf.TRANS_TYPE_CD, btf.DR_CR_FLAG, btf.trans_total_amount
    
  UNION
  
  
  select 
  CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.tendered_amount*1) else
       CASE  WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.tendered_amount*-1)
         end
   
   END as paymentamount
    ,CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.trans_total_amount*1) else
         CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.trans_total_amount*-1)
         end
   
   END as adjustamount
   ,'SELF_PAY' as name
  from batch_trans_file btf
  join pft_encntr pe on pe.pft_encntr_id        = btf.pft_encntr_id
            and pe.active_ind           = 1
  where btf.batch_trans_id     = ?
            and btf.active_ind          = 1
            and btf.nontrans_flag       = 0
            and btf.pft_encntr_id       > 0.0
            and btf.dr_cr_flag          =?
   group by btf.TENDERED_AMOUNT, btf.TRANS_TYPE_CD, btf.DR_CR_FLAG, btf.trans_total_amount  
   
   
  UNION
  
   select 
  CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.tendered_amount*1) else
       CASE  WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.tendered_amount*-1)
         end
   
   END as paymentamount
    ,CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.trans_total_amount*1) else
         CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.trans_total_amount*-1)
         end
   
   END as adjustamount
   ,'SELF_PAY' as name
   from batch_trans_file btf
 
  join encounter e on e.encntr_id             = btf.encntr_id
            and e.active_ind            = 1
            
  where btf.batch_trans_id     = ?
            and btf.active_ind          = 1
            and btf.nontrans_flag       = 0
            and btf.encntr_id+0         > 0.0
            and btf.pft_encntr_id+0     = 0.0
            and btf.dr_cr_flag          =?
   group by btf.TENDERED_AMOUNT, btf.TRANS_TYPE_CD, btf.DR_CR_FLAG, btf.trans_total_amount
   
   UNION
   
    select 
  CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.tendered_amount*1) else
       CASE  WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.tendered_amount*-1)
         end
   
   END as paymentamount
    ,CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.trans_total_amount*1) else
         CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.trans_total_amount*-1)
         end
   
   END as adjustamount
   ,'SELF_PAY' as name
   from batch_trans_file btf
       
  join account a   on a.acct_id               = btf.ar_account_id
             and a.acct_type_cd          = ?
             and a.acct_sub_type_cd      = ?
             and a.active_ind            = 1
          where btf.batch_trans_id      = ?
             and btf.active_ind          = 1
             and btf.nontrans_flag       = 0
             and btf.ar_account_id       > 0.0
             and btf.pft_encntr_id       = 0.0
             and btf.encntr_id           = 0.0
             and btf.corsp_activity_id   = 0.0
             and btf.dr_cr_flag          =?
    group by btf.TENDERED_AMOUNT, btf.TRANS_TYPE_CD, btf.DR_CR_FLAG, btf.trans_total_amount
    
    
    UNION
   
    select 
  CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.tendered_amount*1) else
       CASE  WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.tendered_amount*-1)
         end
   
   END as paymentamount
    ,CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=1 then (btf.trans_total_amount*1) else
         CASE WHEN btf.trans_type_cd=? and btf.dr_cr_flag=2 then (btf.trans_total_amount*-1)
         end
   
   END as adjustamount
   ,'SELF_PAY' as name
   from batch_trans_file btf
    join account a   on a.acct_id               = btf.guar_acct_id
             and a.active_ind            = 1
      where btf.batch_trans_id      = ?
             and btf.active_ind          = 1
             and btf.nontrans_flag       = 0
             and btf.guar_acct_id       > 0.0
             and btf.pft_encntr_id       = 0.0
             and btf.encntr_id           = 0.0
             and btf.corsp_activity_id   = 0.0
             and btf.dr_cr_flag          =?
group by btf.TENDERED_AMOUNT, btf.TRANS_TYPE_CD, btf.DR_CR_FLAG, btf.trans_total_amount   
   
   