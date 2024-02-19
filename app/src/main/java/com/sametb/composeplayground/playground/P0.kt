package com.sametb.composeplayground.playground

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview


/*
* Compose Playground.com.sametb.composeplayground.playground
* Created by SAMET BAYAT 
* on 19.02.2024 at 10:13 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Preview(
    showBackground = true
)
@Composable
fun Bottle() {

    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        val bottleColor = Color(0xFF26A69A)

        val bottleBodyPath = Path().apply {
            moveTo(width * .3f, height * .1f)
            lineTo(width * .3f, height * .2f)
            quadraticBezierTo(
                0f, height * .25f,
                0f, height * .30f
            )
            lineTo(0f, height * .95f)
            quadraticBezierTo(
                0f, height,
                width * .05f, height
            )

            lineTo(width * 0.95f, height)
            quadraticBezierTo(
                width, height,
                width, height * 0.95f
            )
            lineTo(width, height * 0.4f)
            quadraticBezierTo(
                width, height * 0.3f,
                width * 0.7f, height * 0.2f
            )
            lineTo(width * 0.7f, height * 0.2f)
            lineTo(width * 0.7f, height * 0.1f)



            close()
        }


        clipPath(
            path = bottleBodyPath
        ) {
            drawRect(
                color = bottleColor,
                size = size
            )
        }

    }
}


@Composable
fun DrawStuff() {

    Canvas(
        modifier = Modifier
            .fillMaxSize()
        ,
    ) {
        drawCircle(
            color = Color(0xFF00FF00),
            radius = 100f,
            center = Offset(size.width / 2, size.height / 2)
        )


        drawRect(
            color = Color(0xFF00FF00),
            size = size / 10f,
            topLeft = Offset(0f, 0f),
            alpha = 0.3f
        )
    }
}