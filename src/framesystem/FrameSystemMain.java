package framesystem;

public class FrameSystemMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FrameSystemController controller = new
		FrameSystemController();
		FrameSystemView frame = new FrameSystemView(controller);
		frame.setBounds(5,5,800,650);
		frame.setVisible(true);		

	}

}
