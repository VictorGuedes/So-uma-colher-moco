package br.edu.utfpr.md.umacolher.config;

import android.os.Handler;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import br.edu.utfpr.md.umacolher.Sprites.Player;
import br.edu.utfpr.md.umacolher.object.Score;

/**
 * Created by victor on 20/06/17.
 */

public class Assets {

    public static String BACKGROUND = "fundo.png";
    public static String PLAY = "play.png";
    public static String BUTTON = "botao.png";
    public static String MESA = "mesa.png";
    public static String GAMEOVER = "telafinal.png";
    public static String RECORDES = "recordes.png";
    public static ArrayList<String> andarPlayer = new ArrayList<String>();
    public static ArrayList<String> andarInimigo = new ArrayList<String>();
    public static ArrayList<String> playerPegaComida = new ArrayList<String>();
    public static ArrayList<String> tiaAtenta = new ArrayList<String>();

    public static Score pontosTotal;



}
