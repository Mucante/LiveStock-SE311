package livestockvisitor;

public interface Visitor {
	public void Visit(DairyCattle animal);
	public void Visit(BeefCattle animal);


}