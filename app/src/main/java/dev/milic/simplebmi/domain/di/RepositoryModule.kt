package dev.milic.simplebmi.domain.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.milic.simplebmi.data.repository.DataStoreOperationsImpl
import dev.milic.simplebmi.data.repository.DataStoreRadioUnitOperations
import dev.milic.simplebmi.data.repository.Repository
import dev.milic.simplebmi.domain.use_cases.ReadUnitRadioStateUseCase
import dev.milic.simplebmi.domain.use_cases.SaveUnitRadioStateUseCase
import dev.milic.simplebmi.domain.use_cases.UseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideDataStoreUnitOperations(
        @ApplicationContext context: Context
    ): DataStoreRadioUnitOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveUnitRadioStateUseCase = SaveUnitRadioStateUseCase(repository = repository),
            readUnitRadioStateUseCase = ReadUnitRadioStateUseCase(repository = repository)
        )
    }
}