public class Game {
    public Game(int tryCount){
        for(int i = 0; i<tryCount; i++){
            Cars.moveCars();
        }
    }
}
