package com.example.tugasbesar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.tugasbesar.databinding.ActivityMainBinding;
import com.example.tugasbesar.view.SideBar;
import com.example.tugasbesar.view.history.History;
import com.example.tugasbesar.view.home.Home;
import com.example.tugasbesar.view.login.Login;
import com.example.tugasbesar.view.order.Order;
import com.example.tugasbesar.view.payment.Payment;
import com.example.tugasbesar.view.seat.Seat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FragmentManager fragmentManager;
    DrawerLayout drawer;
    SideBar sideBar;
    Login halLogin;
    Home halHome;
    Order halOrder;
    Seat halSeat;
    Payment halPayment;
    History halHistory;
    //BottomNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding=ActivityMainBinding.inflate(this.getLayoutInflater());
        setContentView(binding.getRoot());

        this.halLogin = Login.newInstance();
        this.halHome = Home.newInstance();
        this.halOrder = Order.newInstance();
        this.halSeat = Seat.newInstance();
        this.halPayment = Payment.newInstance();
        this.halHistory = History.newInstance();

        this.fragmentManager=this.getSupportFragmentManager();

        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.halLogin)
                .addToBackStack(null)
                .commit();

        this.getSupportFragmentManager().setFragmentResultListener(
                "changePage", this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        int page = result.getInt("page");
                        changePage(page);
                    }
                }
        );

        //Splash screen
        /*bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnNavigationItemSelectedListener(this);

        loadFragment(new Home());
*/
    }
    /*public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.menu_item_home:
                fragment = new Home();
                break;
            case R.id.menu_item_history:
                fragment = new History();
                break;
            case R.id.menu_item_setting:
                fragment = new Order();
                break;
        }
        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {
       if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }*/
    public void changePage(int page){
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if (page == 0){
            if(this.halLogin.isAdded()){
                ft.show(this.halLogin);
            }
            else{
                ft.add(R.id.fragment_container, this.halLogin).addToBackStack(null);
            }
            if(this.halHome.isAdded()){
                ft.hide(this.halHome);
            }
            if(this.halOrder.isAdded()){
                ft.hide(this.halOrder);
            }
            if (this.halSeat.isAdded()){
                ft.hide(this.halSeat);
            }
            if (this.halPayment.isAdded()){
                ft.hide(this.halPayment);
            }
            if (this.halHistory.isAdded()){
                ft.hide(this.halHistory);
            }
        }
        if (page == 1){
            if(this.halHome.isAdded()){
                ft.show(this.halHome);
            }
            else{
                ft.add(R.id.fragment_container, this.halHome).addToBackStack(null);
            }
            if(this.halLogin.isAdded()){
                ft.hide(this.halLogin);
            }
            if(this.halOrder.isAdded()){
                ft.hide(this.halOrder);
            }
            if (this.halSeat.isAdded()){
                ft.hide(this.halSeat);
            }
            if (this.halPayment.isAdded()){
                ft.hide(this.halPayment);
            }
            if (this.halHistory.isAdded()){
                ft.hide(this.halHistory);
            }
        }
//        else if (page == 2){
//            this.drawer.closeDrawers();
//            closeApplication();
//        }
        else if (page == 3){
            if(this.halOrder.isAdded()){
                ft.show(this.halOrder);
            }
            else{
                ft.add(R.id.fragment_container,this.halOrder).addToBackStack(null);
            }
//            if (this.watchlist.isAdded()){
//                ft.hide(this.watchlist);
//            }
        }
        else if (page == 4){
            if (this.halSeat.isAdded()){
                ft.show(this.halSeat);
            }
            else{
                ft.add(R.id.fragment_container, this.halSeat).addToBackStack(null);
            }
//            if (this.watchlist.isAdded()){
//                ft.hide(this.watchlist);
//            }
//            if (this.editWatchlist.isAdded()){
//                ft.hide(this.editWatchlist);
//            }
        }
        else if (page == 5){
            if (this.halPayment.isAdded()){
                ft.show(this.halPayment);
            }
            else{
                ft.add(R.id.fragment_container, this.halPayment).addToBackStack(null);
            }
//            if (this.seeWatchlist.isAdded()){
//                ft.hide(this.seeWatchlist);
//            }
        }
        else if (page == 6){
            if (this.halHistory.isAdded()){
                ft.show(this.halHistory);
            }
            else{
                ft.add(R.id.fragment_container, this.halHistory).addToBackStack(null);
            }
//            if (this.seeWatchlist.isAdded()){
//                ft.hide(this.seeWatchlist);
//            }
        }
        ft.commit();
    }

    public void closeApplication(){
        this.moveTaskToBack(true);
        this.finish();
    }
}