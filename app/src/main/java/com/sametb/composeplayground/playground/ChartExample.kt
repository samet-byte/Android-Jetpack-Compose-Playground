package com.sametb.composeplayground.playground

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine


/*
* Compose Playground.com.sametb.composeplayground.playground
* Created by SAMET BAYAT 
* on 20.02.2024 at 10:56 PM
* Copyright (c) 2024 UNITED WORLD. All rights reserved.
*/

@Preview
@Composable
fun LineChart() {

    val pointsData: List<Point> =
        listOf(
            Point(0f, 40f),
            Point(1f, 90f),
            Point(2f, 0f),
            Point(3f, 60f),
            Point(4f, 10f)
        )

    val steps = 5

    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(Color.Blue)
        .steps(pointsData.size - 1)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.Red)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i ->
            val yScale = 100 / steps
            (i * yScale)
                .toString()
//                .formatToSinglePrecision()
        }
        .build()


    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(),
                    IntersectionPoint(),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(),
        backgroundColor = Color.White
    )


    LineChart(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        lineChartData = lineChartData
    )

}


//@Preview
//@Composable
//fun BarChart() {
//
////    val barChartData = DataUtils.getBarChartData(barChartListSize, maxRange)
//    val yStepSize = 5
//
//
//    val barChartData = BarChartData(
//        chartData = barChartData,
//        xAxisData = xAxisData,
//        yAxisData = yAxisData,
//        paddingBetweenBars = 20.dp,
//        barWidth = 25.dp
//    )
//
//    val xAxisData = AxisData.Builder()
//        .axisStepSize(30.dp)
//        .steps(barChartData.size - 1)
//        .bottomPadding(40.dp)
//        .axisLabelAngle(20f)
//        .labelData { index -> barData[index].label }
//        .build()
//
//    val yAxisData = AxisData.Builder()
//        .steps(yStepSize)
//        .labelAndAxisLinePadding(20.dp)
//        .axisOffset(20.dp)
//        .labelData { index -> (index * (maxRange / yStepSize)).toString() }
//        .build()
//
//    BarChart(modifier = Modifier.height(350.dp), barChartData = barChartData)
//}

