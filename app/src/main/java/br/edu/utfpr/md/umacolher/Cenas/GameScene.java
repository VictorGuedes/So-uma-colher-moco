package br.edu.utfpr.md.umacolher.Cenas;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.sound.SoundEngine;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import br.edu.utfpr.md.umacolher.R;
import br.edu.utfpr.md.umacolher.Sprites.Inimigo;
import br.edu.utfpr.md.umacolher.Sprites.MesaBackground;
import br.edu.utfpr.md.umacolher.Sprites.Player;
import br.edu.utfpr.md.umacolher.Sprites.ScreenBackground;
import br.edu.utfpr.md.umacolher.Sprites.Tia;
import br.edu.utfpr.md.umacolher.config.Assets;
import br.edu.utfpr.md.umacolher.engines.InimigoEngine;
import br.edu.utfpr.md.umacolher.interfaces.InimigoDelegate;
import br.edu.utfpr.md.umacolher.object.GameButtons;
import br.edu.utfpr.md.umacolher.object.Score;

import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenHeight;
import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenResolution;
import static br.edu.utfpr.md.umacolher.config.DeviceSettings.screenWidth;

/**
 * Created by victor on 20/06/17.
 */

public class GameScene extends CCLayer implements InimigoDelegate {

    private ScreenBackground background;
    private MesaBackground mesaBackground;
    private CCLayer playerLayer;
    private Player player;

    private CCLayer scoreLayer;
    private Score pontos;

    private CCLayer inimigoLayer;
    private Inimigo inimigo;
    private InimigoEngine inimigoEngine;

    private CCLayer tiaLayer;
    private Tia tia;


    private GameScene() {
        setImagens();
        SoundEngine.sharedEngine().playSound(CCDirector.sharedDirector().getActivity(), R.raw.ru, true);

        this.background = new ScreenBackground(Assets.BACKGROUND);
        this.background.setPosition(screenResolution(CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
        this.addChild(this.background);

        this.mesaBackground = new MesaBackground(Assets.MESA);
        this.mesaBackground.setPosition(820, 575);
        this.addChild(this.mesaBackground);

        this.inimigo = new Inimigo();

        GameButtons gameButtonsLayer = GameButtons.gameButtons();
        this.addChild(gameButtonsLayer);

        this.tia = new Tia();

        this.player = new Player();


        this.inimigoLayer = CCLayer.node();
        this.addChild(this.inimigoLayer);

        this.playerLayer = CCLayer.node();
        this.addChild(this.playerLayer);

        this.tiaLayer = CCLayer.node();
        this.addChild(this.tia);

        this.scoreLayer = CCLayer.node();
        this.addChild(this.scoreLayer);

        this.pontos = new Score();

        gameButtonsLayer.setDelegate(this, this.player, this.pontos, this.tia);

        this.addGameObjects();

        player.start();

    }

    public void setImagens(){
        Assets.andarPlayer.add("anda1.png");
        Assets.andarPlayer.add("anda2.png");
        Assets.andarInimigo.add("inimigoAnda.png");
        Assets.andarInimigo.add("inimigoAnda2.png");

        Assets.playerPegaComida.add("pegaComida15.png");
        Assets.playerPegaComida.add("pegaComida24.png");
        Assets.playerPegaComida.add("pegaComida3.png");
        Assets.playerPegaComida.add("pegaComida24.png");
        Assets.playerPegaComida.add("pegaComida15.png");

        Assets.tiaAtenta.add("tiaAtenta.png");
        Assets.tiaAtenta.add("tiaAtenta2.png");
        Assets.tiaAtenta.add("tiaDesatenta.png");
        Assets.tiaAtenta.add("tiaDesatenta2.png");
        Assets.tiaAtenta.add("tiaDesatenta3.png");
        Assets.tiaAtenta.add("tiaPistola.png");
    }

    public static CCScene createGame() {
        CCScene scene = CCScene.node();
        GameScene layer = new GameScene();
        scene.addChild(layer);
        return scene;
    }


    @Override
    public void onEnter() {
        super.onEnter();
        this.startEngines();
    }

    private void startEngines() {

        this.addChild(this.inimigoEngine);
        this.inimigoEngine.setDelegate(this);

    }



    private void addGameObjects() {
        this.playerLayer.addChild(this.player);
        this.inimigoEngine = new InimigoEngine();

        this.scoreLayer.addChild(this.pontos);
        this.tiaLayer.addChild(this.tia);
    }

    public CGRect getBoarders(CCSprite object){
        CGRect rect = object.getBoundingBox();
        CGPoint GLpoint = rect.origin;
        CGRect GLrect = CGRect.make(GLpoint.x, GLpoint.y, rect.size.width, rect.size.height);
        return GLrect;
    }


    @Override
    public void createInimigo() {
        if (player.getAcaoAnddar().getTag() == 0){
            inimigo.setDelegate(this);
            this.inimigoLayer.addChild(inimigo);
            inimigo.criaAnimacao();
            inimigo.start();
            inimigo.iniciaAnimacao();
            this.inimigoEngine.unschedule("playerEngine");
        }
    }


}
