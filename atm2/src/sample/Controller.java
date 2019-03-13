package sample;

import com.sun.glass.ui.View;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Stack;
import java.util.Vector;

public class Controller {
    private int cardNumber=1234;
    private  int sim=1234;
    private int bbalance=0;
    private int flag;
    @FXML
    TextField cardnumber;
    @FXML
    TextField Sim;
    Vector<Transaction> history = new Vector<>();
    int histPtr;
    /*Transaction prev;
    Transaction nex;*/
    @FXML
    Button MainMenu;
    @FXML
    Button enter;
    @FXML
    Button delete;
    @FXML
    Button back;
    @FXML
    Button one;
    @FXML
    Button two;
    @FXML
    Button three;
    @FXML
    Button four;
    @FXML
    Button five;
    @FXML
    Button six;
    @FXML
    Button seven;
    @FXML
    Button eight;
    @FXML
    Button nine;
    @FXML
    Button zero;
    @FXML
    Button deposit;
    @FXML
    Button withdraw;
    @FXML
    Button previous;
    @FXML
    Button next;
    @FXML
    Button balance;
    @FXML
    TextField enteramount;
    @FXML
    TextField blance;
    //@FXML
    /*void number(Source event){

        enteramount.setText(enteramount.getText() +event.getButton(). ;
    }*/
    @FXML
    void One(){

        enteramount.setText(enteramount.getText() + "1");
    }
    @FXML
    void Two(){
        enteramount.setText(enteramount.getText() + "2");
    }
    @FXML
    void Three(){
        enteramount.setText(enteramount.getText() + "3");
    }
    @FXML
    void Four(){
        enteramount.setText(enteramount.getText() + "4");
    }
    @FXML
    void Five(){
        enteramount.setText(enteramount.getText() + "5");
    }
    @FXML
    void Six(){
        enteramount.setText(enteramount.getText() + "6");
    }
    @FXML
    void Seven(){
        enteramount.setText(enteramount.getText() + "7");
    }
    @FXML
    void Eight(){
        enteramount.setText(enteramount.getText() + "8");
    }
    @FXML
    void Nine(){
        enteramount.setText(enteramount.getText() + "9");
    }
    @FXML
    void Zero(){
        enteramount.setText(enteramount.getText() + "0");
    }
    @FXML
    void Balance(){
        blance.setText(String.valueOf(bbalance));

    }
    @FXML
    void Deposit(){
        flag=0;
        setVisible(true);

    }
    @FXML
    void Withdraw(){
        flag=1;
        setVisible(true);

    }
    @FXML
    void Enter(){
        if(flag==0) {
            if(Integer.valueOf(enteramount.getText())<0) {
                blance.setText("Wrong Value");
                return;
            }
            bbalance=bbalance + Integer.valueOf(enteramount.getText());
            try {
                Transaction newTransaction = new Transaction("Deposit", Integer.parseInt(enteramount.getText()));
                history.add(newTransaction);
                if(history.size() == 6) history.remove(0);
            }catch (Exception e){
                e.printStackTrace();
            }
            }
        else {
            if(Integer.valueOf(enteramount.getText())>bbalance) {
                blance.setText("No enough credit");
                return;
            }
            bbalance=bbalance - Integer.valueOf(enteramount.getText());
            try {
                Transaction newTransaction = new Transaction("WithDraw", Integer.parseInt(enteramount.getText()));
                history.add(newTransaction);
                if(history.size() == 6) history.remove(0);

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        histPtr = history.size();
        blance.setText(String.valueOf(bbalance));

    }
    @FXML
    void Back(){
        setVisible(false);
        blance.setText("");
        blance.setPromptText("Balance");
        enteramount.setText("");
        enteramount.setPromptText("Enter Amount");
    }
    @FXML
    void Delete(){

    }
    @FXML
    void Previous() {
        if(histPtr== 0)return;
        blance.setText(history.get(histPtr-1).toString());
        histPtr--;
        if(histPtr < 0) histPtr = 0;
    }
    @FXML
    void Next(){
        if(histPtr >=  history.size()-1)return;
        blance.setText(history.get(histPtr+1).toString());
        histPtr++;
        if(histPtr > history.size())histPtr = history.size();
    }
    void setVisible(Boolean state){
        delete.setVisible(state);
        back.setVisible(state);
        one.setVisible(state);
        two.setVisible(state);
        three.setVisible(state);
        four.setVisible(state);
        five.setVisible(state);
        six.setVisible(state);
        seven.setVisible(state);
        eight.setVisible(state);
        nine.setVisible(state);
        zero.setVisible(state);
        enteramount.setVisible(state);
        enter.setVisible(state);
        withdraw.setVisible(!state);
        deposit.setVisible(!state);
        previous.setVisible(!state);
        next.setVisible(!state);
        balance.setVisible(!state);
    }
    @FXML
    void mainmenu(){
        if(Integer.valueOf(cardnumber.getText())==1234 && Integer.valueOf(Sim.getText())==1234) {
            withdraw.setVisible(true);
            deposit.setVisible(true);
            previous.setVisible(true);
            next.setVisible(true);
            balance.setVisible(true);
            blance.setVisible(true);
            cardnumber.setVisible(false);
            Sim.setVisible(false);
            MainMenu.setVisible(false);
        }
        else MainMenu.setText("Wrong");
    }
}
