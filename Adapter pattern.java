interface Game {
    void playDigital();
}
class modernconsole  {
    void playgame(Game game) {
        game.playDigital();
    }}
class RetroCartridge{
    void insertCartridge() {
        System.out.println("playing retro game");
    }
}
class CartridgeAdapter implements Game {
    RetroCartridge cartridge;
    CartridgeAdapter(RetroCartridge cartridge) {
        this.cartridge = cartridge;
    }
    public void playDigital() {
        cartridge.insertCartridge();
    }
}
public class Main {
    public static void main(String[] args) {
        modernconsole console = new modernconsole();
        RetroCartridge retroCartridge = new RetroCartridge();
        Game adapter = new CartridgeAdapter(retroCartridge);
        console.playgame(adapter);
    }
}
    
