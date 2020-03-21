package com.jty.dandelion.application

import android.app.Application

class DandelionApplication : Application(){

    companion object{

      fun getAccount(): Account{
          return Account()
      }

    }


}