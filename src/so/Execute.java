package so;

public class Execute {
	public static void main(String[] args) {
		
		Process p1 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, 130, 10, 0);
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1);
		
		System.out.println("\n---------------------------------------------------------------------------------------------------");
		
		Process p2 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, 90, 5, 1000);
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p2);
		
		System.out.println("\n---------------------------------------------------------------------------------------------------");
		
		Process p3 = SystemOperation.SystemCall(SystemCallType.CREATE_PROCESS, 30, 15, 1);
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p3);
		
	}
	

}





//escalonador - 5 algoritmos / calclar o tempo que um processo leva para executar as instruções
