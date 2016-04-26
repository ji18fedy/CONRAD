package edu.stanford.rsl.tutorial.xue;

import ij.ImageJ;
import edu.stanford.rsl.conrad.data.numeric.Grid2D;
import edu.stanford.rsl.conrad.data.numeric.InterpolationOperators;
import edu.stanford.rsl.conrad.data.numeric.NumericPointwiseOperators;


public class phantom_test extends Grid2D {

	public phantom_test(int x, int y){
		super(x,y);
		float valueIntensity1;
		float valueIntensity2;
		float valueIntensity3;
		valueIntensity1=0.8f;
		valueIntensity2=0.4f;
		valueIntensity3=0.1f;
		this.setAtIndex(x, y, valueIntensity1);
		for(int i=x/8;i<x/4;i++){
			for(int j=y/8;j<y/4;j++){
				this.setAtIndex(i, j, valueIntensity1);
			}
		}
		
		
		for(int i=(x/2+x/4);i<x/2+2*x/4;i++){
			for(int j=y/4;j<y/4+y/8;j++){
				this.setAtIndex(i, j, valueIntensity2);
			}
		}
		
		for(int i=(x/4);i<x/2+x/4;i++){
			for(int j=y/2+y/8;j<y/2+2*y/8;j++){
				this.setAtIndex(i, j, valueIntensity3);
			}
		}
		
	}
	//public phantom_test()

	public static void main(String[] args) {
		new ImageJ();
		// TODO Auto-generated method stub
		phantom_test yourPhantom = new phantom_test(512,512);
		yourPhantom.show();
	
		Grid2D result1 = new Grid2D(512,512);
		result1= (Grid2D) NumericPointwiseOperators.addedBy(yourPhantom, yourPhantom);
		result1.show("result1");
		
		//InterpolationOperators
		
		//double[] x = new double[512];
		//x = Grid2D.indexToPhysical(5,200);
		
		//double[] y = new double[512];
		//y = Grid2D.physicalToIndex(512,512);
		
		//Grid2D result2 = new Grid2D(512,512);
		//for(int i = 0; i<= 512; i++ ){
	   //		InterpolationOperators.interpolateLinear(yourPhantom, x[i], y[i]);	
			
		//}

		
		

	}

}
