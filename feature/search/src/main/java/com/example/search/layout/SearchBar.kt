import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.LocalColors
import com.example.designsystem.theme.LocalTypography
import com.example.resource.R as ResourceR
import com.example.ui.component.IGText

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChanged: (String) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(LocalColors.current.darkGray)
        ) {
            Icon(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterVertically),
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = ResourceR.string.content_description_search_icon),
                tint = Color.Gray,
            )
            BasicTextField(
                value = query,
                onValueChange = onQueryChanged,
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                textStyle = LocalTypography.current.headline2,
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        IGText(
                            text = stringResource(id = ResourceR.string.search_hint_text),
                            color = Color.Gray,
                            style = LocalTypography.current.headline2,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    innerTextField()
                }
            )
        }
    }


}