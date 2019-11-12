

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.Assert;



import java.sql.ResultSet;
import java.util.ArrayList;

import com.cerner.Remittance_demo.*;
import com.cerner.Remittance_demo.dao.ConnectionClass;
import com.cerner.Remittance_demo.model.CurrencyCode;
import com.cerner.Remittance_demo.model.QueryExecuter;
import com.cerner.Remittance_demo.model.QueryReader;
import com.cerner.Remittance_demo.model.RequestExecuter;
import com.cerner.Remittance_demo.model.RequestReader;
import com.cerner.Remittance_demo.model.ReturnDateValue;
import com.cerner.Remittance_demo.rest.RestService;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Remittance_DemoTest {

	@Before
	public void setup() {

	}
	@Test 
	public void testCurrencyCode() throws Exception
	{
		CurrencyCode c=new CurrencyCode();
		int code=c.getCurrencycode("2450833");
		assertEquals(11074,code);
	}
	@Test 
	public void testCurrencyCodeexception() throws Exception
	{
		CurrencyCode c=new CurrencyCode();
		int code=c.getCurrencycode("00");
		assertEquals(0,code);
	}
	@Test
	public void testConnectionClass() throws Exception {
		ConnectionClass connection=new ConnectionClass();
		boolean a=connection.getConnectionStatus();
		assertEquals(true,a);
	}
	@Test
	public void testRequestExecuter() {
		RequestExecuter exec=new RequestExecuter();
		ArrayList<ResultSet>list = null;
		ArrayList<ResultSet> res;
		res= exec.getReplyList("2449769", "GROUP_BY_PAYER", "DEBIT");
		assertThat(list, is(not(res)));
	}
	
	
	@Test
	public void testRestService() throws Exception {
		RestService srvc =new RestService();
		//MockitoAnnotations.initMocks(this);
		String s="\nDescription=Medicare\n" + 
				"paymentAmount=10\n" + 
				"AdjustmentAmount=12\n" + 
				"Description=SELF_PAY\n" + 
				"paymentAmount=11\n" + 
				"AdjustmentAmount=13\n" + 
				"TotalpaymentAmount=21\n" + 
				"TotalAdjustmentAmount=25";
		String request="{\"groupByFlag\":\"GROUP_BY_PAYER\",\"debitCreditGroupByFlag\":\"DEBIT\",\"remittanceID\":\"2450833\"}";
		String st=srvc.getReply(request);
		assertEquals(s,st);
		
	}
	@Test
	public void testQueryExecuter() {
		QueryExecuter exec=new QueryExecuter();
		ArrayList<ResultSet> expected=null;
		ArrayList<ResultSet> actual=new ArrayList<ResultSet>();
		actual=exec.getQueryResults(1, "2449769");
		assertThat(expected, is(not(actual)));
	}
	@Test
	public void testRequestReader() throws Exception {
		RequestReader read=new RequestReader();
		String expected="\nDescription=Medicare\n" + 
				"paymentAmount=10\n" + 
				"AdjustmentAmount=12\n" + 
				"Description=SELF_PAY\n" + 
				"paymentAmount=11\n" + 
				"AdjustmentAmount=13\n" + 
				"TotalpaymentAmount=21\n" + 
				"TotalAdjustmentAmount=25";
		String request="{\"groupByFlag\":\"GROUP_BY_PAYER\",\"debitCreditGroupByFlag\":\"DEBIT\",\"remittanceID\":\"2450833\"}";
		String actual=read.getResponse(request);
		assertEquals(expected,actual);
		

	}
	@Test
	public void testRequestReaderinputremittancecheck() throws Exception {
		RequestReader read=new RequestReader();
		String expected="Error:Enter valid Remittanceid";
		String request="{\"groupByFlag\":\"GROUP_BY_PAYER\",\"debitCreditGroupByFlag\":\"DEBIT\",\"remittanceID\":\"0\"}";
		String actual=read.getResponse(request);
		assertEquals(expected,actual);
	}
	@Test
	public void testRequestReaderinputgroupbyflagcheck() throws Exception {
		RequestReader read=new RequestReader();
		String expected="Error:Enter valid groupbyflag";
		String request="{\"groupByFlag\":\"GROUP_BY_PAYE\",\"debitCreditGroupByFlag\":\"DEBIT\",\"remittanceID\":\"2450833\"}";
		String actual=read.getResponse(request);
		assertEquals(expected,actual);
	}
	@Test
	public void testRequestReaderinputdebitcreditcecheck() throws Exception {
		RequestReader read=new RequestReader();
		String expected="Error:Enter valid debit credit groupbyflag";
		String request="{\"groupByFlag\":\"GROUP_BY_PAYER\",\"debitCreditGroupByFlag\":\"DEBI\",\"remittanceID\":\"2450833\"}";
		String actual=read.getResponse(request);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testQueryReader() {
		QueryReader read=new QueryReader();
		String actual=read.getQueryData("C:\\Users\\Public\\Documents\\test.txt");
		assertEquals("Hello",actual);
		
	}
	@Test
	public void testQueryReaderfilenotfound() {
		QueryReader read=new QueryReader();
		String actual=read.getQueryData("C:\\Users\\PG074553\\eclipse-workspace\\Uplifting_remmitance_summary\\src\\main\\resources\\test.txt");
		assertEquals("",actual);
	}
		
	@Test
	public void TestReturnDatevalue() {
		Calendar calobj = Calendar.getInstance();
		DateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
		String expected = dateformat.format(calobj.getTime());
		ReturnDateValue dateval=new ReturnDateValue();
		String actual=dateval.getDateValue();
		assertEquals(expected,actual);
		}
}


