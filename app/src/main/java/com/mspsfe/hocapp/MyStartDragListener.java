package com.mspsfe.hocapp;

import android.view.DragEvent;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class MyStartDragListener implements View.OnDragListener {
    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {
        int action = dragEvent.getAction() ;

        switch (action){
            case DragEvent.ACTION_DRAG_STARTED :
                return true ;
          case  DragEvent.ACTION_DRAG_ENDED:
                    return  true ;
         case DragEvent.ACTION_DRAG_ENTERED:
                        return true ;
            case DragEvent.ACTION_DRAG_EXITED:
                            return true ;
           case DragEvent.ACTION_DRAG_LOCATION:
                                return true ;
          case DragEvent.ACTION_DROP:

              View localState =(View) dragEvent.getLocalState() ;
              ViewGroup parent =(ViewGroup) localState.getParent() ;
              if (parent.getId() != R.id.mainLayout){
                 changeLayout(localState,(LinearLayout)parent);
                  changeLocation(view.getX(),view.getY(),(View) localState.getParent());
                  localState.setVisibility(View.VISIBLE);
              }
              else if (parent.getId() ==R.id.mainLayout){
                  LinearLayout newLayout = makeNewLayout(view);
                  changeLayout(localState, newLayout);
                  changeLocation(view.getX(),view.getY(),newLayout);
                    parent.addView(newLayout);}
                    localState.setVisibility(View.VISIBLE);
        }

        return true;
    }
    private LinearLayout makeNewLayout(View view){
        LinearLayout layout = new LinearLayout(view.getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setX(view.getX());
        layout.setY(view.getY());
        layout.setTag("Layout");
        return layout;
        }


    private void changeLayout(View view, LinearLayout newLayout) {
        ((ViewGroup)view.getParent()).removeView(view);
        view.setX(0);
        view.setY(0);
        view.setVisibility(View.VISIBLE);
        newLayout.addView(view);
    }
        private  void changeLocation(float x , float y,View v){
        v.setX(x-100);
        v.setY(y+100);
        }

}
