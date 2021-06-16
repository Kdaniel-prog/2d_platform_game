package kiszel.daniel.graphic;

import java.awt.image.BufferedImage;


/**
 * Ez az osztály azért volt fontos mert képeket használok a játék során
 * Minden kép ami a játékunkhoz van azt ebben az osztályba hoztunk létre. Fontos, hogy a játékoknál egy nagy darab képet hoznak létre és
 * azokból vágják ki a képeket mint ahogy csináltam a playernél a legjobb az lett volna ha minden egy nagy képbe lenne így kevesebb erő forrást igényelne a játék
 * */
public class Assets{
    private static final int height = 100, width = 100;
    public static BufferedImage
            flag,load2,load1,exit1,exit2,menu2,menu1,losebg,wingbg,start2,start1,smoke1,smoke2,smoke3,hp,
            hearthframe,bat1,bat2,Ridle1, Ridle2, Ridle3, Rmove1, Rmove2, Rmove3, Rsquat, Rfall,
            Rjump, Rattack1, Rattack2, Rattack3, RairAttack, dirt, hole, grass, bg, Lidle1, Lidle2, Lidle3,
            Lmove1, Lmove2, Lmove3, Lsquat, Lfall, Ljump, Lattack1, Lattack2, Lattack3, LairAttack;
    public static BufferedImage[] load,exit,menu,start,die_effect,player_Ridle,player_Lidle,player_Rmove,player_Lmove,player_Lattack,player_Rattack,bat_move;

    /**
     * ez Assets init metódusa  tölti be az összes képet és bármelyik osztály hozzá férést kap
     * azt a game.initbe fogom felhasználni
     */
    public static void init(){
        SpriteSheet Rsheet = new SpriteSheet(ImageLoader.loadImage("/testures/SpriteCharacterRight.png"));
        SpriteSheet Lsheet = new SpriteSheet(ImageLoader.loadImage("/testures/SpriteCharacterLeft.png"));

        Ridle1 = Rsheet.crop(0, 0,width,height);
        Ridle2 = Rsheet.crop(126, 0, width,height);
        Ridle3 = Rsheet.crop(250,0,width,height);
        Rmove1 = Rsheet.crop(0,95,width,height);
        Rmove2 = Rsheet.crop(126,95,width,height);
        Rmove3 = Rsheet.crop(260,95,width,height);
        Rattack1 = Rsheet.crop(0,202,width,height+10);
        Rattack2 = Rsheet.crop(100,203,width,height+10);
        Rattack3 = Rsheet.crop(200,205,width,height+10);
        Rsquat = Rsheet.crop(0,306,90,height);
        Rfall = Rsheet.crop(100,306,90,height+10);
        Rjump = Rsheet.crop(210,308,100,height+17);
        RairAttack = Rsheet.crop(320,205,width+20,height+10);

        Lidle1 = Lsheet.crop(0, 0,width,height);
        Lidle2 = Lsheet.crop(116, 0, width,height);
        Lidle3 = Lsheet.crop(245,0,width,height);
        Lmove1 = Lsheet.crop(0,95,width,height);
        Lmove2 = Lsheet.crop(126,95,width,height);
        Lmove3 = Lsheet.crop(260,95,width,height);
        Lattack1 = Lsheet.crop(0,202,width,height+10);
        Lattack2 = Lsheet.crop(110,205,width,height+10);
        Lattack3 = Lsheet.crop(214,208,width,height+10);
        Lsquat = Lsheet.crop(10,306,90,height);
        Lfall = Lsheet.crop(110,306,90,height+10);
        Ljump = Lsheet.crop(220,308,100,height+17);
        LairAttack = Lsheet.crop(330,205,width+20,height+10);
        bat1 = ImageLoader.loadImage("/testures/bat1.png");
        bat2 = ImageLoader.loadImage("/testures/bat2.png");

        grass = ImageLoader.loadImage("/testures/grass.png");
        hole = ImageLoader.loadImage("/testures/hole.png");
        dirt = ImageLoader.loadImage("/testures/dirt.png");
        bg = ImageLoader.loadImage("/testures/bg.png");
        hearthframe = ImageLoader.loadImage("/testures/frame.png");
        hp = ImageLoader.loadImage("/testures/hearth.png");
        smoke1 = ImageLoader.loadImage("/testures/smoke1.png");
        smoke2 = ImageLoader.loadImage("/testures/smoke2.png");
        smoke3 = ImageLoader.loadImage("/testures/smoke3.png");
        start1 = ImageLoader.loadImage("/testures/start1.png");
        start2 = ImageLoader.loadImage("/testures/start2.png");
        wingbg =  ImageLoader.loadImage("/testures/youWin.png");
        losebg =  ImageLoader.loadImage("/testures/gameover.png");
        menu1 = ImageLoader.loadImage("/testures/menu1.png");
        menu2 = ImageLoader.loadImage("/testures/menu2.png");
        exit1 = ImageLoader.loadImage("/testures/exit1.png");
        exit2 = ImageLoader.loadImage("/testures/exit2.png");
        load1 = ImageLoader.loadImage("/testures/load1.png");
        load2 = ImageLoader.loadImage("/testures/load2.png");
        flag = ImageLoader.loadImage("/testures/flag.png");


        player_Ridle = new BufferedImage[3];
        player_Lidle = new BufferedImage[3];

        player_Rmove = new BufferedImage[3];
        player_Lmove = new BufferedImage[3];


        player_Rattack = new BufferedImage[2];
        player_Lattack = new BufferedImage[2];


        bat_move = new BufferedImage[2];

        die_effect = new BufferedImage[3];

        start = new BufferedImage[2];
        menu = new BufferedImage[2];
        exit = new BufferedImage[2];
        load = new BufferedImage[2];


        start[0] = start1;
        start[1] = start2;

        load[0] = load1;
        load[1] = load2;

        menu[0] = menu1;
        menu[1] = menu2;

        exit[0] = exit1;
        exit[1] = exit2;


        bat_move[0] = bat1;
        bat_move[1] = bat2;

        player_Ridle[0] = Ridle1;
        player_Ridle[1] = Ridle2;
        player_Ridle[2] = Ridle3;

        player_Lidle[0] = Lidle1;
        player_Lidle[1] = Lidle2;
        player_Lidle[2] = Lidle3;

        player_Rmove[0] = Rmove1;
        player_Rmove[1] = Rmove2;
        player_Rmove[2] = Rmove3;

        player_Lmove[0] = Lmove1;
        player_Lmove[1] = Lmove2;
        player_Lmove[2] = Lmove3;

        die_effect[0] = smoke1;
        die_effect[1] = smoke2;
        die_effect[2] = smoke3;

    }

}
