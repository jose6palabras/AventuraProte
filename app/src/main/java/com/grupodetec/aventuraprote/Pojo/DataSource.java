package com.grupodetec.aventuraprote.Pojo;

import com.grupodetec.aventuraprote.R;
import com.grupodetec.aventuraprote.View.CardViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 19/12/18.
 */

public class DataSource {
    public DataSource() {
    }
    public List<CardViewModel> sitesData(){
        List<CardViewModel> sitesCardViewModels;
        sitesCardViewModels = new ArrayList<>();
        sitesCardViewModels.add(new CardViewModel(R.drawable.site1, "Cabellera venus", "Media Cuesta"));
        sitesCardViewModels.add(new CardViewModel(R.drawable.site3, "Microcuenca", "Potreros"));
        sitesCardViewModels.add(new CardViewModel(R.drawable.site4, "Mirador Cocorná", "Chorrera"));
        return sitesCardViewModels;
    }
    public List<CardViewModel> foodData(){
        List<CardViewModel> foodCardViewModels;
        foodCardViewModels = new ArrayList<>();
        foodCardViewModels.add(new CardViewModel(R.drawable.food1, "Asado al Carbón", "Restaurante 1"));
        foodCardViewModels.add(new CardViewModel(R.drawable.food2, "Hamburguesa de Pollo", "Restaurante 2"));
        foodCardViewModels.add(new CardViewModel(R.drawable.food3, "Pizza Artesanal", "Restaurante 3"));
        foodCardViewModels.add(new CardViewModel(R.drawable.food4, "Punta de Anca", "Restaurante 4"));
        return foodCardViewModels;
    }
    public  List<CardViewModel> hotelData(){
        List<CardViewModel> hotelCardViewModels;
        hotelCardViewModels = new ArrayList<>();
        hotelCardViewModels.add(new CardViewModel(R.drawable.hotel1, "Hotel 1", "Parque principal"));
        hotelCardViewModels.add(new CardViewModel(R.drawable.hotel2, "Hotel 2", "Parque principal"));
        hotelCardViewModels.add(new CardViewModel(R.drawable.hotel3, "Hotel 3", "Cra 21 34-32"));
        hotelCardViewModels.add(new CardViewModel(R.drawable.hotel4, "Hotel 4", "Calle 19 23-22"));
        return hotelCardViewModels;
    }
    public List<CardViewModel> adventureData(){
        List<CardViewModel> adventureCardViewModels;
        adventureCardViewModels = new ArrayList<>();
        adventureCardViewModels.add(new CardViewModel(R.drawable.adventure1, "Downhill", "Cocorná MTB"));
        adventureCardViewModels.add(new CardViewModel(R.drawable.adventure2, "Parapente", "Prestador 1"));
        adventureCardViewModels.add(new CardViewModel(R.drawable.adventure3, "Rafting", "Prestador 2"));
        adventureCardViewModels.add(new CardViewModel(R.drawable.adventure4, "Rappel", "Prestador 3"));
        return adventureCardViewModels;
    }
    public List<CardViewModel> nightData(){
        List<CardViewModel> nightCardViewModels;
        nightCardViewModels = new ArrayList<>();
        nightCardViewModels.add(new CardViewModel(R.drawable.night1, "Cocktails", "Parque principal"));
        nightCardViewModels.add(new CardViewModel(R.drawable.night2, "Disco 2", "Parque principal"));
        nightCardViewModels.add(new CardViewModel(R.drawable.night3, "Disco 3", "Cra 21 34-32"));
        nightCardViewModels.add(new CardViewModel(R.drawable.night4, "Disco 4", "Calle 19 23-22"));
        return nightCardViewModels;
    }
}
