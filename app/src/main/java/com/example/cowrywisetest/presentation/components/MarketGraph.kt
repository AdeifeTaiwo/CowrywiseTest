package com.example.cowrywisetest.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cowrywisetest.ui.theme.CowryWiseGraphGradientOne
import com.example.cowrywisetest.ui.theme.CowryWiseGreen
import com.example.cowrywisetest.ui.theme.CowryWiseLightBlue
import com.example.cowrywisetest.ui.theme.CowrywiseTestTheme
import com.example.cowrywisetest.utils.GraphType
import kotlin.math.abs
import kotlin.math.pow

/**
 * this Composable is used draw the Market Graph, it also shows a moveable Marker
 */
@Composable
fun SmoothGraphWithMovableMarker(
    selectedGraphType: String = GraphType.THIRTY_DAYS.value
) {
    val dataPoints = listOf(
        Offset(20f, 400f), // Start point
        Offset(70f, 380f), // Gentle rise
        Offset(230f, 220f), // First peak // Smooth dip
        Offset(390f, 360f), // Deeper valley to almost starting point
        Offset(470f, 220f), // Smooth rise
        Offset(550f, 170f), // Second peak
        Offset(570f, 160f), //flatten
        Offset(650f, 160f), // Gentle steep up
    )
    // State for the marker position
    var markerX by remember { mutableFloatStateOf(dataPoints[0].x) }
    var markerY by remember { mutableStateOf(dataPoints[0].y) }

    var xLabels = listOf("01 Jun", "07 Jun", "15 Jun", "23 Jun", "30 Jun") // X-axis labels
    if(selectedGraphType == GraphType.NINETY_DAYS.value) xLabels = listOf("01 Jun", "07 Jun", "15 Jul", "23 Jul", "30 Aug")


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {



        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()

                        // Get screen width dynamically
                        val screenWidth = size.width

                        // Prevent marker from going beyond the last data point and screen width
                        val maxX = minOf(dataPoints.last().x, screenWidth - 20f) // Add padding

                        markerX = (markerX + dragAmount.x)
                            .coerceIn(dataPoints.first().x, maxX) // Clamp X within bounds


                        markerY = getCubicBezierYForX(dataPoints, markerX) // Get exact Y
                    }
                }
        ) {
            val path = Path().apply {
                moveTo(dataPoints.first().x, dataPoints.first().y)

                for (i in 1 until dataPoints.size) {
                    val start = dataPoints[i - 1]
                    val end = dataPoints[i]
                    val control1 = Offset((start.x + end.x) / 2, start.y) // Control towards the previous point
                    val control2 = Offset((start.x + end.x) / 2, end.y)   // Control towards the next point

                    cubicTo(control1.x, control1.y, control2.x, control2.y, end.x, end.y)
                }

                // Close the path to fill the area below
                lineTo(dataPoints.last().x, size.height) // Drop to bottom
                lineTo(dataPoints.first().x, size.height) // Extend to left edge
            }


            //Gradient fill
            drawPath(
                path = path,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        CowryWiseLightBlue,
                        Color.Transparent
                    ),
                    startY = dataPoints.minOf { it.y },
                    endY = size.height
                ),
                style = Fill
            )


            // Draw smooth graph path
            drawPath(path, color = CowryWiseGraphGradientOne, style = Stroke(width = 0f))

            //Draw Dotted Steps along Y-Axis
            val stepCount = 7
            val stepHeight = size.height / stepCount
            for (i in 0..stepCount) {
                drawCircle(
                    color = Color.White.copy(alpha = 0.5f),
                    center = Offset(20f, i * stepHeight),
                    radius = 3f
                )
            }

            // **Draw Dotted Steps along X-Axis**
            val stepWidth = (size.width - 100) / (9) // Distribute along X-axis
            for (i in 0..9) {
                drawCircle(
                    color = Color.White.copy(alpha = 0.5f),
                    center = Offset(20f + i * stepWidth, size.height - 0),
                    radius = 3f
                )
            }

            // Draw the main white dot on the curve
            drawCircle(
                color = Color.White,
                center = Offset(markerX, markerY),
                radius = 8f
            )

            // Draw the draggable green marker (perfectly aligned with curve)
            drawCircle(
                color = Color.Green,
                center = Offset(markerX, markerY),
                radius = 10f,
                style = Stroke(width = 4f) //Hollow marker
            )
        }

        // Find closest data point for label display
        val closestPoint = dataPoints.minByOrNull { abs(it.x - markerX) } ?: dataPoints.first()
        val labelX = xLabels.getOrNull(dataPoints.indexOf(closestPoint)) ?: xLabels.last()
        val labelY = closestPoint.y.toInt() // Convert to meaningful value if needed

        // Green popup label (attached to marker)
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset { IntOffset(markerX.toInt() - 20, markerY.toInt() - 350) }
                .background(CowryWiseGreen, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Text("$labelX\n1 EUR = $labelY", color = Color.White, fontSize = 12.sp)
        }


        //X-axis labels
        Row(
            modifier = Modifier
                .offset { IntOffset(20, 280) }
                .fillMaxWidth()
                .padding(end = 16.dp, top = 4.dp, bottom = 4.dp, start = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            xLabels.forEach { label ->
                Text(
                    text = label,
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

/**
 * Computes the exact Y value for a given X on the Cubic Bézier curve
 */
fun getCubicBezierYForX(points: List<Offset>, x: Float): Float {
    val closestIndex = points.indexOfFirst { it.x > x }.coerceAtLeast(1)
    if (closestIndex < 1) return points.first().y
    if (closestIndex >= points.size) return points.last().y

    val start = points[closestIndex - 1]
    val end = points[closestIndex]
    val control1 = Offset((start.x + end.x) / 2, start.y) // Adjust control1 position
    val control2 = Offset((start.x + end.x) / 2, end.y)   // Adjust control2 position

    val t = (x - start.x) / (end.x - start.x) // Normalize X

    // **Cubic Bézier Formula**
    return (1 - t).pow(3) * start.y + 3 * (1 - t).pow(2) * t * control1.y +
            3 * (1 - t) * t.pow(2) * control2.y + t.pow(3) * end.y
}




@Composable
@Preview
fun PreviewCryptoItem() {
  CowrywiseTestTheme  {
       SmoothGraphWithMovableMarker()
    }

}

