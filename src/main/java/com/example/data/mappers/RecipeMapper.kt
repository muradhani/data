package com.example.data.mappers

import com.example.data.models.RecipeDto
import com.example.domain.mappers.Mapper
import com.example.domain.models.RecipeEntity

class RecipeMapper: Mapper<RecipeDto, RecipeEntity> {
    override fun dtoToEntity(input: RecipeDto): RecipeEntity {
        return RecipeEntity(
            id = input.pk,
            title = input.title,
            imageUrl = input.imageUrl,
            rating = input.rating,
            publisher = input.publisher,
            sourceUrl = input.sourceUrl,
            description = input.description,
            cookingInstructions = input.cookingInstructions,
            ingredients = input.ingredients,
            dateAdded = input.dateAdded,
            dateUpdated = input.dateUpdated
        )
    }
    override fun entityToDto(input: RecipeEntity): RecipeDto {
        return RecipeDto(
            pk = input.id,
            title = input.title,
            imageUrl = input.imageUrl,
            rating = input.rating,
            publisher = input.publisher,
            sourceUrl = input.sourceUrl,
            description = input.description,
            cookingInstructions = input.cookingInstructions,
            ingredients = input.ingredients,
            dateAdded = input.dateAdded,
            dateUpdated = input.dateUpdated
        )
    }

    override fun dtoListToEntityList(input: List<RecipeDto>): List<RecipeEntity> {
        return input.map {
            dtoToEntity(it)
        }
    }

    override fun entityListToDtoList(input: List<RecipeEntity>): List<RecipeDto> {
        return input.map {
            entityToDto(it)
        }
    }
}