package com.sabekur2017.digitalwallet.di

import com.sabekur2017.digitalwallet.data.repositories.WalletRepositoriesImpl
import com.sabekur2017.digitalwallet.data.sources.WalletDatasource
import com.sabekur2017.digitalwallet.data.sources.WalletDatasourceImpl
import com.sabekur2017.digitalwallet.domain.repositories.WalletRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideWalletDatasource(): WalletDatasource {
        return WalletDatasourceImpl()
    }

    @Provides
    @Singleton
    fun provideWalletRepository(datasource: WalletDatasource): WalletRepositories {
        return WalletRepositoriesImpl(datasource)
    }
}
