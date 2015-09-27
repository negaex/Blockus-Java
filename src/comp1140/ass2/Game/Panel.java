package comp1140.ass2.Game;

import comp1140.ass2.Scenes.Game;
import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by nosha on 25/09/15.
 */
public final class Panel extends GridSprite {

    ArrayList<PieceSprite> pieceSprites = new ArrayList<>();
    public ArrayList<Shape> shapes= new ArrayList<>();
    Colour color;
    public PieceSprite temporary = null;
    Game parent;
    boolean active = false;


    public Panel(int col, int row, int size, Colour color, Game parent, boolean vertical) {
        super(col, row, size, color, parent);
        this.parent = parent;
        this.color = color;
        for(Node node : this.getChildren()) {
            node.setOpacity(0.2);
        }
        this.setActive(false);


        if(vertical) {
            addPiece(Shape.A, 1, 1);
            addPiece(Shape.B, 3, 1);
            addPiece(Shape.C, 5, 1);
            addPiece(Shape.D, 7, 1);
            addPiece(Shape.E, 1, 5);
            addPiece(Shape.F, 2, 13);
            addPiece(Shape.G, 2, 13);
            addPiece(Shape.H, 2, 13);
            addPiece(Shape.I, 2, 13);
            addPiece(Shape.J, 2, 13);
            addPiece(Shape.K, 2, 13);
            addPiece(Shape.L, 2, 13);
            addPiece(Shape.M, 2, 13);
            addPiece(Shape.N, 2, 13);
            addPiece(Shape.O, 2, 13);
            addPiece(Shape.P, 2, 13);
            addPiece(Shape.Q, 2, 13);
            addPiece(Shape.R, 2, 13);
            addPiece(Shape.S, 2, 13);
            addPiece(Shape.T, 2, 13);
            addPiece(Shape.U, 2, 13);
        }
        else {
            addPiece(Shape.A, 1, 1);
            addPiece(Shape.B, 1, 3);
            addPiece(Shape.C, 1, 6);
            addPiece(Shape.E, 3, 1);
            addPiece(Shape.J, 5, 1);
            addPiece(Shape.G, 3, 6);
            addPiece(Shape.D, 7, 1);
            addPiece(Shape.F, 7, 6);
            addPiece(Shape.H, 10, 1);
            addPiece(Shape.I, 10, 4);
            addPiece(Shape.J, 14, 1);
            addPiece(Shape.K, 14, 1);
            addPiece(Shape.L, 14, 1);
            addPiece(Shape.M, 14, 1);
            addPiece(Shape.N, 14, 1);
            addPiece(Shape.O, 14, 1);
            addPiece(Shape.P, 14, 1);
            addPiece(Shape.Q, 14, 1);
            addPiece(Shape.R, 14, 1);
            addPiece(Shape.S, 14, 1);
            addPiece(Shape.T, 14, 1);
            addPiece(Shape.U, 14, 1);
        }
    }

    public void addPiece(Shape shape, int x, int y) {
        Piece myPiece = new Piece(shape, color);
        myPiece.setXY(new Coordinate(x, y));
        PieceSprite myPieceSprite = new PieceSprite(myPiece, xsize, this);
        pieceSprites.add(myPieceSprite);
        shapes.add(shape);
        this.addPieceSprite(myPieceSprite);
    }

    public void removePiece(Shape shape) {
        //int index = pieces.indexOf(piece);
        int index = shapes.indexOf(shape);
        if(index==-1) return;
        //System.out.println(pieceSprites.size()+ ", "+pieces.size());
        PieceSprite sprite = pieceSprites.get(index);
        pieceSprites.remove(index);
        shapes.remove(index);
        //pieces.remove(index);
        this.removePieceSprite(sprite);
    }

    public void isClicked(PieceSprite sprite) {
        if(!active) {
            return;
        }
        if(temporary != null) {
            pieceSprites.add(temporary);
            shapes.add(temporary.piece.shape);
            //pieces.add(temporary.piece);
            this.addPieceSprite(temporary);
        }
        temporary = sprite;
        this.removePieceSprite(sprite);
        parent.piecePreparer.addShape(sprite.piece.shape, color);
        pieceSprites.remove(sprite);
        //pieces.remove(sprite.piece);
        shapes.remove(sprite.piece.shape);
    }

    public void setActive(boolean active) {
        this.active = active;
        if(active) {
            this.setOpacity(1);
        }
        else {
            this.setOpacity(0.4);
        }
    }
}