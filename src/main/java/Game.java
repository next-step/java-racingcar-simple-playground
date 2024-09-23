public class Game {
    public Game(){
        int tryCount = View.inputTryCount();
        for(int i = 0; i<tryCount; i++){
            Cars.moveCars();
        }
    }
}
