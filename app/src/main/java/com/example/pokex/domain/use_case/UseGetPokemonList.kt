package com.example.pokex.domain.use_case

import com.example.pokex.Until.Resource
import com.example.pokex.domain.model.ElementOfPokeList
import com.example.pokex.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class UseGetPokemonList(val userRepository: UserRepository) {

    operator fun invoke(offset:Int,limit:Int): Flow<Resource<MutableList<ElementOfPokeList>>> = flow {
        try {
            emit(Resource.Loading<MutableList<ElementOfPokeList>>())
            val coin = userRepository.getPokemonList(offset,limit)
            emit(Resource.Success<MutableList<ElementOfPokeList>>(coin))
        } catch(e: Exception) {
            emit(Resource.Error<MutableList<ElementOfPokeList>>(e.localizedMessage ?: "An unexpected error occured"))
        }
    }

}