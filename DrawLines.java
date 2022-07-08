public class DrawLines {
    DrawLines(){
    }

    public void createLines(){

        if (BlackBoard.getInstance().getPoints() != null){

            for (int i = 0; i < BlackBoard.getInstance().getPoints().size() - 1; i++){

                Line l = new Line(BlackBoard.getInstance().getPoints().get(i), BlackBoard.getInstance().getPoints().get(i + 1));
                BlackBoard.getInstance().addLine(l);
            }
        } 

        return;
    }
}
