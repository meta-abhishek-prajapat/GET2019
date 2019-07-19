
public class Processes {
	
		Integer totalProcess;
		Integer processTimings[][];
		Integer waitingTime[];
		Integer turnAroundTime[];
		Integer completionTime[];
		Integer avgWaitingTime;

		//initialize the total number of process and arrival and burst time of process
		public Processes(Integer totalProcess, Integer[][] processTimings) {
				super();
				this.totalProcess = totalProcess;
				this.processTimings = processTimings;
		}
		
		//evaluate waiting, turn around time, avg waiting and completion time
		public void Evaluate(){
		
				this.waitingTime=WaitingTime();
				this.turnAroundTime=TurnAroundTime();
				this.avgWaitingTime=AverageWaintingTime();
				this.completionTime=CompletionTime();
		}

		
		private Integer[] WaitingTime(){
				Integer waitingTime[]=new Integer[this.totalProcess];;
				waitingTime[0]=0;
				int total=this.processTimings[0][1];
				for(int loop=1;loop<this.totalProcess;loop++){
						if(total>this.processTimings[loop][0]){
								waitingTime[loop]=total-this.processTimings[loop][0];
								total+=this.processTimings[loop][1];
						}else{
							waitingTime[loop]=0;
						}
				}
				System.out.println(total);
				return waitingTime;
		}

		private Integer[] TurnAroundTime(){
			Integer tat[]=new Integer[this.totalProcess];
			for(int loop=0;loop<this.totalProcess;loop++){
					tat[loop]=this.processTimings[loop][1]+this.waitingTime[loop];
			}
			return tat;
		}

		private Integer AverageWaintingTime(){
			Integer totalWaitingTime=0;
			for(int loop=0;loop<this.totalProcess;loop++){
					totalWaitingTime+=this.waitingTime[loop];
			}
			return totalWaitingTime/this.totalProcess;
		}

		private Integer[] CompletionTime(){
				Integer completionTime[]=new Integer[this.totalProcess];
				Integer total=0;
				for(int loop=0;loop<this.totalProcess;loop++){
						if(total<this.processTimings[loop][0]){
							total=(this.processTimings[loop][0]+this.processTimings[loop][1]);
							completionTime[loop]=total;
						}else{
						total+=this.processTimings[loop][1];
						completionTime[loop]=total;
						}
				}
				return completionTime;
		}

		public Integer MaximumWaitingTime(){
				Integer maxWaitTime=0;
				for(int loop=0;loop<this.totalProcess;loop++){
						if(maxWaitTime<this.waitingTime[loop])
							maxWaitTime=this.waitingTime[loop];
				}
				return maxWaitTime;
		}

		public void ShowInfo(){
				System.out.println("Pno.\tArrivalTime\tBurstTime\tWaitingTime\tTurnAroundTime\tCompletionTime");
				for(int loop=0;loop<this.totalProcess;loop++){
						System.out.println((loop+1)+"\t\t"+this.processTimings[loop][0]+"\t\t"+this.processTimings[loop][1]+"\t\t"+this.waitingTime[loop]+"\t\t"+this.turnAroundTime[loop]+"\t\t"+this.completionTime[loop]);
				}
				System.out.println("Average Waiting Time: "+this.avgWaitingTime);
				System.out.println("Maximum Waiting Time: "+this.MaximumWaitingTime());
		
		}

}
