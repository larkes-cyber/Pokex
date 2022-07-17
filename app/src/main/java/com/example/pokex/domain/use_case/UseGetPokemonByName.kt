package com.example.pokex.domain.use_case

import com.example.pokex.Until.Resource
import com.example.pokex.domain.model.ElementOfPokeList
import com.example.pokex.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class UseGetPokemonByName(val userRepository: UserRepository) {

    operator fun invoke(name:String): Flow<Resource<ElementOfPokeList>> = flow {
        try {
            emit(Resource.Loading<ElementOfPokeList>())
            val element = userRepository.getPokemonByName(name)
            emit(Resource.Success<ElementOfPokeList>(element))
        } catch(e: Exception) {
            emit(Resource.Error<ElementOfPokeList>(e.localizedMessage ?: "An unexpected error occured"))
        }
    }

}