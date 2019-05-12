package dairyvisitor;

import dairyfactory.BeefCattle;
import dairyfactory.DairyCattle;

public interface Visitor {
	public void Visit(DairyCattle animal);
	public void Visit(BeefCattle animal);


}
