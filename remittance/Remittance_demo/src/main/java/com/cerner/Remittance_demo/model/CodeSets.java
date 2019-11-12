package com.cerner.Remittance_demo.model;

import com.cerner.Remittance_demo.dao.CodeValue;

/**
 * CodeSets class returns the code values of required code sets and also values
 * of particular string variables.
 * 
 * @author PG074553
 *
 */
public class CodeSets {
	CodeValue cv = new CodeValue();
	// below strings returns the file path of sql files.
	public static final String groupbypayerbySelfPay = "\\src\\main\\resources\\GroupByPayerbySelfPay.sql";
	public static final String groupbypayerbyClientResearch = "\\src\\main\\resources\\GroupByPayerbyClientResearch.sql";
	public static final String groupbypayerbyIME = "\\src\\main\\resources\\GroupByPayerbyIME.sql";
	public static final String currencycode = "\\src\\main\\resources\\CurrencyCode.sql";

	private float CS25753_REVERSAL = 0;
	private float CS18937_REVERSAL = 0;
	private float CS18649_PAYMENT = 0;
	private float CS18649_ADJUST = 0;
	private float CS25753_TRANSFER = 0;
	private float CS354_SELFPAY = 0;
	private float CS18736_AR = 0;
	private float CS319_FIN_NUMBER = 0;
	private float CS21849_STATEMENT = 0;
	private float CS20549_COPAY = 0;
	private float CV69_RECURRING = 0;
	private float CS20549_BD_RECOVERY = 0;
	private float CS20549_BD_WRITEOFF = 0;
	private float CS20549_BD_REVERSAL = 0;
	private float CS20549_BANKRUPTCYREVERSAL = 0;
	private float CS20549_BANKRUPTCY = 0;
	private float CS23372_COMPWERROR = 0;
	private float CS23372_WORKING = 0;
	private float CS20569_INERROR = 0;
	private float CS20569_ERRLOCK = 0;
	private float CS20569_ELECTRONIC = 0;
	private float CS20569_INACTIVEENC = 0;
	private float CS20569_PENDING = 0;
	private float CS21849_CLAIM = 0;
	private float CS21849_INVOICE_CD = 0;
	private float CS20849_PATIENT = 0;
	private float CS20849_CLIENT = 0;
	private float CS21849_STATEMENT_CD = 0;
	private float CS351_DEFGUAR_CD = 0;
	private float CS20790_PRIORITYSEQ = 0;
	private float CS18936_CLIENT_CD = 0;
	private float CS18936_PATIENT = 0;
	private float CS21749_HCFA_1450 = 0;
	private float CS21749_HCFA_1500 = 0;
	private float CS4002034_IME_BILLING = 0;
	private float CS20849_RESEARCH = 0;
	private float CS20849_GENERAL = 0;
	private float CS18736_NONAR_GLONLY_CD = 0;

	public float getCS18936_CLIENT_CD() {
		return cv.getCodeValue(18936, "CLIENT");
	}

	public void setCS18936_CLIENT_CD(float cS18936_CLIENT_CD) {
		CS18936_CLIENT_CD = cS18936_CLIENT_CD;
	}

	public float getCS351_DEFGUAR_CD() {
		return cv.getCodeValue(351, "DEFGUAR");
	}

	public void setCS351_DEFGUAR_CD(float cS351_DEFGUAR_CD) {
		CS351_DEFGUAR_CD = cS351_DEFGUAR_CD;
	}

	public float getCS20569_PENDING() {
		return cv.getCodeValue(20569, "PENDING");
	}

	public void setCS20569_PENDING(float cS20569_PENDING) {
		CS20569_PENDING = cS20569_PENDING;
	}

	public float getCV69_RECURRING() {
		return cv.getCodeValue(69, "RECURRING");
	}

	public void setCV69_RECURRING(float cV69_RECURRING) {
		CV69_RECURRING = cV69_RECURRING;
	}

	public float getCS354_SELFPAY() {
		return cv.getCodeValue(354, "SELFPAY");
	}

	public void setCS354_SELFPAY(float cS354_SELFPAY) {
		CS354_SELFPAY = cS354_SELFPAY;
	}

	public float getCS18649_ADJUST() {
		return cv.getCodeValue(18649, "ADJUST");
	}

	public void setCS18649_ADJUST(float cS18649_ADJUST) {
		CS18649_ADJUST = cS18649_ADJUST;
	}

	public float getCS18649_PAYMENT() {
		return cv.getCodeValue(18649, "PAYMENT");
	}

	public void setCS18649_PAYMENT(float cS18649_PAYMENT) {
		CS18649_PAYMENT = cS18649_PAYMENT;
	}

	public float getCS18937_REVERSAL() {
		return cv.getCodeValue(18937, "REVERSAL");
	}

	public void setCS18937_REVERSAL(float cS18937_REVERSAL) {
		CS18937_REVERSAL = cS18937_REVERSAL;
	}

	public float getCS25753_REVERSAL() {
		return cv.getCodeValue(25753, "REVERSAL");
	}

	public void setCS25753_REVERSAL(float cS25753_REVERSAL) {
		CS25753_REVERSAL = cS25753_REVERSAL;
	}

	public float getCS18736_AR() {
		return cv.getCodeValue(18736, "A/R");
	}

	public void setCS18736_AR(float cS18736_AR) {
		CS18736_AR = cS18736_AR;
	}

	public float getCS21849_CLAIM() {
		return cv.getCodeValue(21849, "CLAIM");
	}

	public void setCS21849_CLAIM(float cS21849_CLAIM) {
		CS21849_CLAIM = cS21849_CLAIM;
	}

	public float getCS21849_INVOICE_CD() {
		return cv.getCodeValue(21849, "STATEMENTINV");
	}

	public void setCS21849_INVOICE_CD(float cS21849_INVOICE_CD) {
		CS21849_INVOICE_CD = cS21849_INVOICE_CD;
	}

	public float getCS20849_PATIENT() {
		return cv.getCodeValue(20849, "PATIENT");
	}

	public void setCS20849_PATIENT(float cS20849_PATIENT) {
		CS20849_PATIENT = cS20849_PATIENT;
	}

	public float getCS20849_CLIENT() {
		return cv.getCodeValue(20849, "CLIENT");
	}

	public void setCS20849_CLIENT(float cS20849_CLIENT) {
		CS20849_CLIENT = cS20849_CLIENT;
	}

	public float getCS21849_STATEMENT_CD() {
		return cv.getCodeValue(21849, "PATIENT STAT");
	}

	public void setCS21849_STATEMENT_CD(float cS21849_STATEMENT_CD) {
		CS21849_STATEMENT_CD = cS21849_STATEMENT_CD;
	}

	public float getCS20790_PRIORITYSEQ() {
		return cv.getCodeValue(20790, "PRIORITY_SEQ");
	}

	public void setCS20790_PRIORITYSEQ(float cS20790_PRIORITYSEQ) {
		CS20790_PRIORITYSEQ = cS20790_PRIORITYSEQ;
	}

	public float getCS18936_PATIENT() {
		return cv.getCodeValue(18936, "PATIENT");
	}

	public void setCS18936_PATIENT(float cS18936_PATIENT) {
		CS18936_PATIENT = cS18936_PATIENT;
	}

	public float getCS21749_HCFA_1450() {
		return cv.getCodeValue(21749, "HCFA_1450");
	}

	public void setCS21749_HCFA_1450(float cS21749_HCFA_1450) {
		CS21749_HCFA_1450 = cS21749_HCFA_1450;
	}

	public float getCS21749_HCFA_1500() {
		return cv.getCodeValue(21749, "HCFA_1500");
	}

	public void setCS21749_HCFA_1500(float cS21749_HCFA_1500) {
		CS21749_HCFA_1450 = cS21749_HCFA_1500;
	}

	public float getCS4002034_IME_BILLING() {
		return cv.getCodeValue(4002034, "IME BILLING");
	}

	public void setCS4002034_IME_BILLING(float cS4002034_IME_BILLING) {
		CS4002034_IME_BILLING = cS4002034_IME_BILLING;
	}

	public float getCS20849_RESEARCH() {
		return cv.getCodeValue(20849, "RESEARCH");
	}

	public void setCS20849_RESEARCH(float cS20849_RESEARCH) {
		CS20849_RESEARCH = cS20849_RESEARCH;
	}

	public float getCS20849_GENERAL() {
		return cv.getCodeValue(20849, "GENERAL");
	}

	public void setCS20849_GENERAL(float cS20849_GENERAL) {
		CS20849_GENERAL = cS20849_GENERAL;
	}

	public float getCS18736_NONAR_GLONLY_CD() {
		return cv.getCodeValue(18736, "NONAR GLONLY");
	}

	public void setCS18736_NONAR_GLONLY_CD(float cS18736_NONAR_GLONLY_CD) {
		CS20849_GENERAL = cS18736_NONAR_GLONLY_CD;
	}
}
