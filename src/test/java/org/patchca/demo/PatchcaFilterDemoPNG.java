package org.patchca.demo;

import java.awt.Color;
import java.io.FileOutputStream;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.filter.predefined.DiffuseRippleFilterFactory;
import org.patchca.filter.predefined.DoubleRippleFilterFactory;
import org.patchca.filter.predefined.MarbleRippleFilterFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;

public class PatchcaFilterDemoPNG {

	public static void main(String[] args) throws Exception {
		for (int counter = 0; counter < 5; counter++) {
			ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
			cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
			switch (counter % 5) {
			case 0:
				cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
				break;
			case 1:
				cs.setFilterFactory(new MarbleRippleFilterFactory());
				break;
			case 2:
				cs.setFilterFactory(new DoubleRippleFilterFactory());
				break;
			case 3:
				cs.setFilterFactory(new WobbleRippleFilterFactory());
				break;
			case 4:
				cs.setFilterFactory(new DiffuseRippleFilterFactory());
				break;
			}
			FileOutputStream fos = new FileOutputStream("patcha_demo" + counter + ".png");
			EncoderHelper.getChallangeAndWriteImage(cs, "png", fos);
			fos.close();
		}
	}
}
