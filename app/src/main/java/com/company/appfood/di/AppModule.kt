//package com.company.appfood.di
//
//import android.app.Application
//import androidx.room.Room
//import com.company.appfood.data.local.SahelFoodDataBase
//import com.company.appfood.data.repository.UserRepositoryImpl
//import com.company.appfood.domain.repository.UserRepository
//import com.company.appfood.utils.Constants.DATABASE_NAME
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object  AppModule {
//    @Provides
//    @Singleton
//    fun provideUserDataBase(app : Application) = Room.databaseBuilder(
//        app,
//        SahelFoodDataBase::class.java,
//        DATABASE_NAME
//    ).build()
//
//    @Provides
//    @Singleton
//    fun provideRepository(db: SahelFoodDataBase) : UserRepository {
//        return UserRepositoryImpl(db.userDao())
//    }
//}