
public class PipelineNode {
	public int pos;
	public String name;
	public PipelineNode next;
	
	public PipelineNode (int argPos, String argName, PipelineNode argNext) {
		pos = argPos;
		name = argName;
		next = argNext;
	}
}
