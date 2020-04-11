package Hotel;

import org.junit.Test;
import org.easymock.EasyMock;
import static org.junit.Assert.*;


public class InHotelTestUsingEasyMock {
	private IData iData=null;
	
	@Test
	public void testInSuccess(){
		iData=EasyMock.createMock(IData.class);
		
		EasyMock.expect(iData.in_Out_Room(101, "����")).andReturn("�����ɹ���ס101���䣡");
		
		EasyMock.replay(iData);
		
		InHotel inHotel=new InHotel(iData);
		String result=inHotel.in(101,  "����");
		assertEquals("�����ɹ���ס101���䣡", result);
		
		EasyMock.verify(iData);
	}
	
	@Test
	public void testInFailure(){
		iData=EasyMock.createMock(IData.class);
		
		EasyMock.expect(iData.in_Out_Room(101, "����")).andReturn("�÷����Ѿ��п�����ס��");
		
		EasyMock.replay(iData);
		
		InHotel inHotel=new InHotel(iData);
		assertEquals(inHotel.in(101,  "����"), "�÷����Ѿ��п�����ס��");
		
		EasyMock.verify(iData);
		
	}

}