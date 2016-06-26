package xyz.phyoekhant.harthapadaythar.data.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import xyz.phyoekhant.harthapadaythar.HarthaPadaytharApp;
import xyz.phyoekhant.harthapadaythar.R;
import xyz.phyoekhant.harthapadaythar.data.vos.JokeVO;

/**
 * Created by Phyoe Khant on 6/25/2016.
 */
public class JokeModel{
        private static JokeModel objInstance;

        private List<JokeVO> jokeList;

        private JokeModel() {
            jokeList = setUpInitialJokes();
        }

        public static JokeModel getInstance() {
            if (objInstance == null) {
                objInstance = new JokeModel();
            }

            return objInstance;
        }

        private List<JokeVO> setUpInitialJokes() {
            Context context = HarthaPadaytharApp.getContext();

            List<JokeVO> jokeList = new ArrayList<>();
            jokeList.add(new JokeVO(context.getString(R.string.joke_one_title), context.getString(R.string.joke_one_content), R.drawable.joke_1));
            jokeList.add(new JokeVO(context.getString(R.string.joke_two_title), context.getString(R.string.joke_two_content), R.drawable.joke_2));
            jokeList.add(new JokeVO(context.getString(R.string.joke_three_title), context.getString(R.string.joke_three_content), R.drawable.joke_3));
            return jokeList;
        }

        public JokeVO getJoke(int index) {
            return jokeList.get(index);
        }
}
