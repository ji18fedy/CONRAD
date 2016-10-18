package edu.stanford.rsl.tutorial.xue;

import ij.ImageJ;
import edu.stanford.rsl.conrad.data.numeric.Grid2D;
import edu.stanford.rsl.conrad.data.numeric.InterpolationOperators;
import edu.stanford.rsl.conrad.data.numeric.NumericPointwiseOperators;


public class phantom_test extends Grid2D {

	public phantom_test(int x, int y){
		
		// Definition of the position and the intensity.
		super(x,y);
		float valueIntensity1 = 0.5f;
		float valueIntensity2 = 0.2f;
		float valueIntensity3 = 0.1f;
		
		// the first geometric object
		for(int i=x/8;i<x/4;i++){
			for(int j=y/8;j<y/4;j++){
				this.setAtIndex(i, j, valueIntensity1);
			}
		}
		
		// the second geometric object
		for(int i=(x/2+x/4);i<x/2+2*x/4;i++){
			for(int j=y/4;j<y/4+y/8;j++){
				this.setAtIndex(i, j, valueIntensity2);
			}
		}
		
		// the third geometric Object
		for(int i=(x/4);i<x/2+x/4;i++){
			for(int j=y/2+y/8;j<y/2+2*y/8;j++){
				this.setAtIndex(i, j, valueIntensity3);
			}
		}
		
		// the fourth geometric object
		for(int i=0;i<512;i++){
			
			for (int j =0;j<512;j++){
				if(Math.pow(i-512/2,2)+ Math.pow(j-512/2,2)< Math.pow(50,2)){
					this.setAtIndex(i,j,1.0f);
				}	
			}
		}
	}
	//public phantom_test()

	public static void main(String[] args) {
		
		ImageJ image = new ImageJ();
		
		// TODO Auto-generated method stub
		phantom_test phantom = new phantom_test(512,512);
		
		phantom.show();

	}

}
