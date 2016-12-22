package businesslogic.orderbl;

import java.util.Calendar;

import javax.script.ScriptContext;

public class MyTask {
	private  static  final  int  C_SCHEDULE_HOUR      =  0;    
	private  static  boolean  isRunning  =  false;    
	//private  ScriptContext  context  =  null;    
	public  MyTask()  {    
	     
	    }    
	public  void  run()  {    
	   Calendar  cal  =  Calendar.getInstance();                    
	   if  (!isRunning)    {                          
	        if  (C_SCHEDULE_HOUR  ==  cal.get(Calendar.HOUR_OF_DAY))  {                            
	             isRunning  =  true;                                    
	            
	                                                
	             
	              
	            isRunning  =  false;    
	           
	        }  else  {    
	     
	      }    
	 }

}
}
