package so;

import java.util.List;
import java.util.Objects;

import so.memory.MemoryManager;
import so.schedule.FCFS;
import so.schedule.Lotery;
import so.schedule.Priority;
import so.schedule.SJF;
import so.schedule.Schedule;

public class SystemOperation {
	public static MemoryManager mm;
	public static Schedule schedule;
	
	public static Process SystemCall(SystemCallType type, int sizeInMemory, int timeToExecute, int priority) {
		if(type.equals(SystemCallType.CREATE_PROCESS)) {
			if (Objects.isNull(mm)) {
				mm = new MemoryManager();
			}
			if (Objects.isNull(schedule)) {
				//schedule = new FCFS();
				//schedule = new Priority();
				//schedule = new SJF();
				schedule = new Lotery();
				
			}

		}
		return new Process(sizeInMemory, timeToExecute, priority);
	}
	
	public static List<SubProcess> systemCall(SystemCallType type, Process p) {
		if (type.equals(SystemCallType.WRITE_PROCESS)) {
			
			if (mm.checkWrite(p)) {
				mm.write(p);
				schedule.addProcessAndSubProcess(p);
			} else {
				System.out.println("########################");
				System.out.println("PAGE FAULT");
				System.out.println("########################");
			}
			
		} else if (type.equals(SystemCallType.CLOSE_PROCESS)) {
			//mm.delete(p);
			//schedule.finish(p);
		} else if (type.equals(SystemCallType.READ_PROCESS)) {
			return mm.read(p);
			
		}
		return null;
	}
	
	

}
