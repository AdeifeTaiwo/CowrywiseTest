package com.example.cowrywisetest.components

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.example.cowrywisetest.R
import com.example.cowrywisetest.ui.theme.CowryWiseBlue
import com.example.cowrywisetest.ui.theme.CowrywiseTestTheme
import kotlinx.coroutines.delay
import java.lang.Math.abs
import kotlin.math.PI

@Composable
fun CowrywiseCustomLoader(pulseFraction: Float = 1.2f, content: @Composable () -> Unit) {

   // val systemUiController: SystemUiController = rememberSystemUiController()
   // systemUiController.isStatusBarVisible = false // Status bar

    //systemUiController.isNavigationBarVisible = false // Navigation bar
    //systemUiController.isSystemBarsVisible = false // Status & Navigation bars
   // systemUiController.systemBarsBehavior =
    //    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    val infiniteTransition = rememberInfiniteTransition()

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = pulseFraction,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    Popup(
        alignment = Alignment.TopStart,
        properties = PopupProperties(
            excludeFromSystemGesture = false,
            clippingEnabled = true
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .clickable(enabled = false) { }) {

            content()
            val showLoader = remember{ mutableStateOf(true) }
            LaunchedEffect(key1 = Unit, block = {
                delay(4000)

            })

            if(showLoader.value) {
                Canvas(
                    modifier = Modifier
                        .background(color = Color.LightGray.copy(0.3f))
                        .clickable(false) {}
                        .fillMaxSize(),
                ) {}
                CircularProgressbar(modifier = Modifier)
            }


        }
    }


}


@Composable
fun CircularProgressbar(
    modifier: Modifier = Modifier,
    number: Float = 70f,
    numberStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    size: Dp = 70.dp,
    indicatorThickness: Dp = 9.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    foregroundIndicatorColor: Color = Color.Red,
    backgroundIndicatorColor: Color = CowryWiseBlue, numberR: Float = 10f
) {
    // It remembers the number value
    // var numberR by remember {
    // mutableStateOf(70f)
    // }
    val RotationsPerCycle = 5
    // Each rotation is 1 and 1/3 seconds, but 1332ms divides more evenly
    val RotationDuration = 1332
    // When the rotation is at its beginning (0 or 360 degrees) we want it to be drawn at 12 o clock,
    // which means 270 degrees when drawing.
    val StartAngleOffset = -90f
    // How far the base point moves around the circle
    val BaseRotationAngle = 286f
    // How far the head and tail should jump forward during one rotation past the base point
    val JumpRotationAngle = 290f
    // Each rotation we want to offset the start position by this much, so we continue where
    // the previous rotation ended. This is the maximum angle covered during one rotation.
    val RotationAngleOffset = (BaseRotationAngle + JumpRotationAngle) % 360f
    //val RotationDuration = 1332
    val HeadAndTailAnimationDuration = (RotationDuration * 0.5).toInt()
    val HeadAndTailDelayDuration = HeadAndTailAnimationDuration
    val CircularEasing = CubicBezierEasing(0.4f, 0f, 0.2f, 1f)
    //val transition = rememberInfiniteTransition()
    // The current rotation around the circle, so we know where to start the rotation from
    val transition = rememberInfiniteTransition()
    // The current rotation around the circle, so we know where to start the rotation from
    val currentRotation by transition.animateValue(
        0,
        RotationsPerCycle,
        Int.VectorConverter,
        infiniteRepeatable(
            animation = tween(
                durationMillis = RotationDuration * RotationsPerCycle,
                easing = LinearEasing
            )
        ), label = ""
    )
    CircularProgressIndicator()
    // How far forward (degrees) the base point should be from the start point
    val baseRotation by transition.animateFloat(
        0f,
        BaseRotationAngle,
        infiniteRepeatable(
            animation = tween(
                durationMillis = RotationDuration,
                easing = LinearEasing
            )
        ), label = ""
    )
    // How far forward (degrees) both the head and tail should be from the base point
    val endAngle by transition.animateFloat(
        0f,
        JumpRotationAngle,
        infiniteRepeatable(
            animation = keyframes {
                durationMillis = HeadAndTailAnimationDuration + HeadAndTailDelayDuration
                0f at 0 with CircularEasing
                JumpRotationAngle at HeadAndTailAnimationDuration
            }
        ), label = ""
    )
    val startAngle by transition.animateFloat(
        0f,
        JumpRotationAngle,
        infiniteRepeatable(
            animation = keyframes {
                durationMillis = HeadAndTailAnimationDuration + HeadAndTailDelayDuration
                0f at HeadAndTailDelayDuration with CircularEasing
                JumpRotationAngle at durationMillis
            }
        ), label = ""
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(size = size)
    ) {
        Box(
            modifier = modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFFFFF))
        )
        Canvas(
            modifier = Modifier
                .progressSemantics()
                .size(size = size)
        ) {
            // Background circle
            drawCircle(
                color = backgroundIndicatorColor,
                radius = size.toPx() / 2,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
            val currentRotationAngleOffset = (currentRotation * RotationAngleOffset) % 360f
            // How long a line to draw using the start angle as a reference point
            val sweep = abs(endAngle - startAngle)
            // Offset by the constant offset and the per rotation offset
            val offset = StartAngleOffset + currentRotationAngleOffset + baseRotation
            //val offset = StartAngleOffset + currentRotationAngleOffset + baseRotation
            this.drawIndeterminateCircularIndicator(
                startAngle + offset,
                indicatorThickness,
                sweep,
                foregroundIndicatorColor,
                Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
        }
        val infiniteTransition = rememberInfiniteTransition()
        val scale by infiniteTransition.animateFloat(
            initialValue = 1f,
            targetValue = 1.7f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse
            ), label = ""
        )

        Image(
            modifier = Modifier
                .size(30.dp)
                .scale(scale)
                .padding(4.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.cowrywise_full_logo),
            contentDescription = null
        )
    }

}

private fun DrawScope.drawIndeterminateCircularIndicator(
    startAngle: Float,
    strokeWidth: Dp,
    sweep: Float,
    color: Color,
    stroke: Stroke
) {
    val CircularIndicatorDiameter = 40.dp
    // Length of arc is angle * radius
    // Angle (radians) is length / radius
    // The length should be the same as the stroke width for calculating the min angle
    val squareStrokeCapOffset =
        (180.0 / PI).toFloat() * (strokeWidth / (CircularIndicatorDiameter / 2)) / 2f

    // Adding a square stroke cap draws half the stroke width behind the start point, so we want to
    // move it forward by that amount so the arc visually appears in the correct place
    val adjustedStartAngle = startAngle + squareStrokeCapOffset

    // When the start and end angles are in the same place, we still want to draw a small sweep, so
    // the stroke caps get added on both ends and we draw the correct minimum length arc
    val adjustedSweep = kotlin.math.max(sweep, 0.1f)

    this.drawCircularIndicator(adjustedStartAngle, adjustedSweep, color, stroke)
}


fun DrawScope.drawCircularIndicator(
    adjustedStartAngle: Float,
    adjustedSweep: Float,
    color: Color,
    stroke: Stroke
) {

    drawArc(
        color = CowryWiseBlue,
        startAngle = adjustedStartAngle,
        sweepAngle = adjustedSweep,
        style = stroke,
        useCenter = false,
    )

    //Circulator

}


@Composable
@Preview
fun PreviewAlatLoader(){
    CowrywiseTestTheme() {
        CowrywiseCustomLoader {
        }
    }
}
