abstract public class Event {
	private long evtTime;
	private int prioridade;
	public Event(long eventTime, int prioridade) {
		evtTime = eventTime;
		this.prioridade = prioridade;
	}
	
	public int getPrioridade(){
		return prioridade;
	}
	
	public boolean ready() {
		return System.currentTimeMillis() >= evtTime;
	}
	
	abstract public void action();
	
	abstract public String description();
} 