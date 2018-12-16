package com.example.phakjira.namjai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class FacebookLogin extends AppCompatActivity {
    CallbackManager callbackManager;
    AccessTokenTracker accessTokenTracker;
    LoginButton loginButton;
    AccessToken accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);


        callbackManager = CallbackManager.Factory.create();


        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("email", "user_gender"));
        //loginButton.setReadPermissions("email");

        // Callback registration
        //loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        //  @Override
            /*public void onSuccess(LoginResult loginResult) {
                // App code
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                try{
                                Log.v("LoginActivity", response.toString());

                                // Application code
                                String email = object.getString("email");
                                String gender = object.getString("gender");

                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "email,gender");
                request.setParameters(parameters);
                request.executeAsync();
                        } catch(JSONException e) {}


            }

            @Override
            public void onCancel() {
                Log.v("LoginActivity", "cancel");

                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                Log.v("LoginActivity", exception.getCause().toString());

                // App code
            }
        });

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {


                // Set the access token using
                // currentAccessToken when it's loaded or set.

            }
        };
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

    }

    /*callbackManager = CallbackManager.Factory.create();

    // Callback registration
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            // App code
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            Log.v("LoginActivity", response.toString());

                            // Application code
                            String email = object.getString("email");
                            String birthday = object.getString("birthday"); // 01/31/1980 format
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender,birthday");
            request.setParameters(parameters);
            request.executeAsync();


        }

        @Override
        public void onCancel() {
            // App code
            Log.v("LoginActivity", "cancel");
        }

        @Override
        public void onError(FacebookException exception) {
            // App code
            Log.v("LoginActivity", exception.getCause().toString());
        }
    });
}

    /*public void getRequest(View v) {
        accessToken = AccessToken.getCurrentAccessToken();

        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        //EditText editText = (EditText)findViewById(R.id.multiLineText);
                        String str = "";
                        try { /*Toast.makeText(MainActivity.this, "Getting ID:" + object.getString("id"),
            Toast.LENGTH_SHORT).show();*/
        //JSONArray postDataArray = object.getJSONObject("email").getJSONArray("email");
        //String email=object.getJSONObject("email").toString();
                            /*for( int postIdx = 0; postIdx < postDataArray.length(); postIdx++) {
                                JSONObject post = postDataArray.getJSONObject(postIdx);
                                if (post.has("message")) {
                                    str = str + post.getString("id")
                                            + " : " + post.getString("message").substring(0, 2) + "\n";
                                }
                            }*/
        //editText.setText(str);
                            /*Intent go=new Intent(getApplication(),CreateUser.class);
                            go.putExtra("email",email);
                            startActivity(go);
                        }catch (JSONException e) {
                            Intent go=new Intent(getApplication(),CreateUser.class);
                            go.putExtra("email","hi");
                            startActivity(go);
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("email", "email");
        request.setParameters(parameters);
        request.executeAsync();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
    }*/

    /*public void onClicked(View view) {
        Intent createUser = new Intent(this, CreateUser.class);
        startActivity(createUser);
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
    }*/
    }

    public void onClickedNext(View view){
        Intent createUser = new Intent(this, CreateUser.class);
        startActivity(createUser);
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
    }

}
