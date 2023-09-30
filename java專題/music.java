import java.applet.Applet;
import java.applet.AudioClip;


public class  music extends Applet{
	 AudioClip audioclip;
	
	public void playmusic (){
		
		audioclip = Applet.newAudioClip(music.class.getResource("1.wav"));
		audioclip.loop(); 
	}
        public void stopmusic(){
		
		 //audioclip = Applet.newAudioClip(music.class.getResource("1.wav"));
		audioclip.stop(); 	

	}
}