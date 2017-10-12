package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
    //Deklarere variablerne!
    TextField txtnuml, txtnum2;
    Button btnadd, btnsub, btndiv, btnmul, btnclear;
    Label lblanswer;

    @Override
    public void start(Stage primaryStage){
        //Laver controllers og initialisere dem!
        txtnuml = new TextField();              //Tekstfelt til første Nummer
        txtnum2 = new TextField();              //Tekstfelt til andet Nummer
        btnadd = new Button("+");          //Knap til at lægge numre sammen
        btnsub = new Button("-");          //Knap til at trække numre fra
        btnmul = new Button("x");          //Knap til at gang numre sammen
        btndiv = new Button("/");          //Knap til at dividere numre med hinanden
        btnclear = new Button("Clear");    //Knap til at slette indhold i felterne
        lblanswer = new Label("?");        //En Label til vores svar og fejlbeskeder
        lblanswer.setAlignment(Pos.CENTER);     //Placerer teksten i label i midten
        //Påfører CSS-ish syntakst til Label, så den bliver pæ at se på.
        lblanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");

        //Laver et grid, som vores program kan være i.
        GridPane root = new GridPane();
        //Ligger vores beholder af programmet (grid) i midten af scenen
        root.setAlignment(Pos.CENTER);
        //Setspacing imellem hver control
        root.setHgap(10);
        root.setVgap(10);
        //Læg data til grid, celle efter celle
        root.add(btnadd,0,0);
        root.add(btnsub,1,0);
        root.add(btnmul,0,1);
        root.add(btndiv,1,1);
        root.add(txtnuml,0,2);
        root.add(txtnum2,1,2);
        //De sidste 2 rækker strækker sig gennem 2 kolonner
        //columnIndex, rowIndex, colspan,  rowspan
        root.add(lblanswer,0,3,2,1);
        root.add(btnclear,0,4,2,1);
        //Laver en metode til at sætte alle widths i alle controls separat
        setWidths();
        //Laver en metode til at lægge kode til knapperne
        attachCode();
        //Sætter scenen
        Scene scene = new Scene(root, 300, 250);  //Scenen bliver sat med width på 300px, og height på 250px.
        primaryStage.setTitle("Mathtastic 3000");               //Laver titlen på programmet
        primaryStage.setScene(scene);                           //Sætter scenen!
        primaryStage.show();                                    //Viser scenen!
    }

    public void setWidths(){
        //Vores metode til at sætte widths på alle controls
        txtnuml.setPrefWidth(70);   //sæt Width: 70px
        txtnum2.setPrefWidth(70);   //sæt Width: 70px
        btnadd.setPrefWidth(70);    //sæt Width: 70px
        btnsub.setPrefWidth(70);    //sæt Width: 70px
        btnmul.setPrefWidth(70);    //sæt Width: 70px
        btndiv.setPrefWidth(70);    //sæt Width: 70px
        btnclear.setPrefWidth(150); //sæt Width: 150px
        lblanswer.setPrefWidth(150);//sæt Width: 150px
    }

    public void attachCode(){
        //Hver knap skal kører en kode tilhørende til knappen, når den bliver trykket på:
        btnadd.setOnAction(e -> btncode(e));    //Hvis knappen + er trykket, køre følgende btncode
        btnsub.setOnAction(e -> btncode(e));    //Hvis knappen - er trykket, køre følgende btncode
        btnmul.setOnAction(e -> btncode(e));    //Hvis knappen x er trykket, køre følgende btncode
        btndiv.setOnAction(e -> btncode(e));    //Hvis knappen / er trykket, køre følgende btncode
        btnclear.setOnAction(e -> btncode(e));  //Hvis knappen Clear er trykket, køre følgende btncode
    }
    public void btncode(ActionEvent e){
        //Vores metode til at køre koden, når knapperne er blevet trykket
        //Deklarere variabler!
        int num1, num2, answer;
        char symbol;
        //Vores action (e) fortæller os hvilken knap der er blevet trykket:

        if(e.getSource()==btnclear){ //Hvis knappen Clear er trykket, kør følgende btncode:
            txtnuml.setText("");     //Tekstfelt Num1 = slet alt indhold
            txtnum2.setText("");     //Tekstfelt Num2 = slet alt indhold
            lblanswer.setText("?");  //Hvis Label med vores svar er tomt, udkriv "?"
            txtnuml.requestFocus();  //Sæt fokus til Tekstfelt Num1, så man hurtigt kan bruge programmet igen!
            return;
        }

        //Læs tallene fra Tekstfelterne Num1 og Num2
        num1 = Integer.parseInt(txtnuml.getText());
        num2 = Integer.parseInt(txtnum2.getText());

        if (e.getSource() == btnadd){   //Hvis knappen + er trykket, kør følgende btncode:
            symbol = '+';               //Initialiser variablen symbol til at være +
            answer = num1 + num2;       //Læg Num1 og Num2 sammen
        }
        else if (e.getSource() == btnsub){
            symbol = '-';               //Initialiser variablen symbol til at være -
            answer = num1 - num2;       //Træk Num1 og Num2 fra hinanden
        }
        else if (e.getSource() == btnmul){
            symbol = 'x';               //Initialiser variablen symbol til at være x
            answer = num1 * num2;       //Gang Num1 og Num2 sammen
        }
        else{
            symbol = '/';               //Initialiser variablen symbol til at være /
            answer = num1 / num2;       //Divider Num1 og Num2 med hinanden
        }
        //Udskriv svaret i vores Label!
        lblanswer.setText("" + num1 + symbol + num2 + "=" + answer);

    }

    //Kør Main metoden!
    public static void main(String[] args) {
        launch(args);
    }
}
