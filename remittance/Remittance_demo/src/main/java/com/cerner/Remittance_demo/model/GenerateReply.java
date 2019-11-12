package com.cerner.Remittance_demo.model;

import java.sql.ResultSet;
import org.json.simple.JSONObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * GenerateReply class returns reply for the request.
 * 
 * @author PG074553
 *
 */
public class GenerateReply {

	/**getReply function structe the reply format and returns the reply.
	 * @param ListOfResultsets
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public String getReply(ArrayList ListOfResultsets) throws SQLException {
		
		ResultSet rsofIMEclaims = null;
		ResultSet rsofSelfPay = null;
		ResultSet rsofClientResearch = null;
		StringBuilder sb = new StringBuilder();
		int IMEPaymentamount = 0;
		int IMEAdjustamount = 0;
		int SelfPayPaymentamount = 0;
		int SelfPayAdjustamount = 0;
		int PaymentTotal = 0;
		int AdjustTotal = 0;
		int ClientResearchPayment = 0;
		int ClientResearchadjust = 0;
		ArrayList<ResultSet> ListofResultSets = ListOfResultsets;
		rsofIMEclaims = ListofResultSets.get(0);
		rsofSelfPay = ListofResultSets.get(1);
		rsofClientResearch = ListofResultSets.get(2);

		while (rsofIMEclaims.next()) {
			int i = rsofIMEclaims.getInt("paymentamount");
			int j = rsofIMEclaims.getInt("adjustamount");
			IMEPaymentamount = IMEPaymentamount + i;
			IMEAdjustamount = IMEAdjustamount + j;
		}
		while (rsofSelfPay.next()) {
			int k = rsofSelfPay.getInt("paymentamount");
			int l = rsofSelfPay.getInt("adjustamount");
			SelfPayPaymentamount = SelfPayPaymentamount + k;
			SelfPayAdjustamount = SelfPayAdjustamount + l;

		}
		while (rsofClientResearch.next()) {
			int m = rsofClientResearch.getInt("paymentamount");
			int n = rsofClientResearch.getInt("adjustamount");
			ClientResearchPayment = ClientResearchPayment + m;
			ClientResearchadjust = ClientResearchadjust + n;

		}
		PaymentTotal = PaymentTotal + IMEPaymentamount + SelfPayPaymentamount + ClientResearchPayment;
		AdjustTotal = AdjustTotal + IMEAdjustamount + SelfPayAdjustamount + ClientResearchadjust;
		sb.append("\n" + "Description=Medicare");
		sb.append("\n" + "paymentAmount=" + IMEPaymentamount);
		sb.append("\n" + "AdjustmentAmount=" + IMEAdjustamount);
		sb.append("\n" + "Description=SELF_PAY");
		sb.append("\n" + "paymentAmount=" + SelfPayPaymentamount);
		sb.append("\n" + "AdjustmentAmount=" + SelfPayAdjustamount);
		sb.append("\n" + "TotalpaymentAmount=" + PaymentTotal);
		sb.append("\n" + "TotalAdjustmentAmount=" + AdjustTotal);

		JSONObject obj = new JSONObject();
		obj.put("Description", "Medicare");
		obj.put("PaymentAmount", IMEPaymentamount);
		obj.put("AdjustmentAmount", IMEAdjustamount);
		obj.put("Description1", "SELF_PAY");
		obj.put("PaymentAmount1", SelfPayPaymentamount);
		obj.put("AdjustmentAmount1", SelfPayAdjustamount);
		obj.put("TotalpaymentAmount",PaymentTotal);
		obj.put("TotalAdjustmentAmount",AdjustTotal);
		String result=obj.toString();

		return sb.toString();

	}

}
