package model_dbao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import dbao.FoodAccessor;
import dbao.ServerAccessor;
import dbao.StationTicketAccessor;
import dbao.TicketAccessor;
import dbo.*;
import dbo.Servers;
import dbo.Station_Ticket;
import dbo.Ticket;

public class InsertObjectsTest {
	final int stat = 13; //add one to this each time you run this.
	
	//Variables
	FoodAccessor fa;
	ServerAccessor sa;
	StationTicketAccessor sta;
	TicketAccessor ta;
	
	Food f;
	Servers s;
	Station_Ticket st;
	Ticket t;
	
	@SuppressWarnings("deprecation")
	Date start = new Date(2001,11,10);
	@SuppressWarnings("deprecation")
	Date end = new Date(2001, 12, 10);
	int counter = 0;
	SessionFactory factory =new Configuration()
			 .configure("hibernate.cfg.xml")
			 .addAnnotatedClass(Food.class)
			 .addAnnotatedClass(Servers.class)
			 .addAnnotatedClass(Station_Ticket.class)
			 .addAnnotatedClass(Ticket.class)
			 .buildSessionFactory();
	Session session;
	//End Variables
	
	@Before
	public void setUp() throws Exception {
		session = factory.getCurrentSession();
		fa = new FoodAccessor(factory, session);
		sa = new ServerAccessor(factory, session);
		sta = new StationTicketAccessor(factory, session);
		ta = new TicketAccessor(factory, session);
	}

	@Test
	public void AddNewFoodItem() {
		f = new Food("Rocks","Gravel",5,"Trees");//Auto recreate object
		assertTrue(fa.AddNewRecord(f, session));
	}
	@Test
	public void AddNewEmptyFoodItem()
	{
		f = new Food(); //Make sure food is empty
		assertFalse(fa.AddNewRecord(f, session));
	}
	@Test
	
	public void AddOneColFoodOnly()
	{
		f = new Food("Rocks",null,0,null);
		assertFalse(fa.AddNewRecord(f, session));
	}
	@Test
	public void AddTimeFoodOnly()
	{
		f = new Food(null,null,1,null);
		assertFalse(fa.AddNewRecord(f, session));
	}

	@Test
	public void AddFullNewServer()
	{
		s = new Servers("Matt","Roz"+counter++);
		
		assertTrue(sa.AddNewRecord(s, session));
	}
	@Test
	public void AddNewEmptyServer()
	{
		s = new Servers();
		assertFalse(sa.AddNewRecord(s, session));
	}
	
	@Test
	public void AddNewEmptyStationTicket()
	{
		st = new Station_Ticket();
		assertFalse(sta.AddStationTicket(st, session));
	}

	@Test
	public void AddFullTicket()
	{
		t= new Ticket(1,1,LocalDateTime.now(),LocalDateTime.now().plusHours(1));
		assertTrue(ta.AddTicket(t, session));
	}
	
	@Test
	public void AddNewTicket()
	{
		t = new Ticket();
		assertFalse(ta.AddTicket(t, session));
	}
}
