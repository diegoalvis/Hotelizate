import React from 'react'
import {
    Text,
    View,
    StyleSheet,
    TouchableWithoutFeedback,
    Image
} from 'react-native'

import Icon from 'react-native-vector-icons/FontAwesome'

const Header = props => {
    const {navigate} = props.navigation
    const {itemSelected} = props
    return (
        <View style={styles.container}>
            <TouchableWithoutFeedback onPress={() => props.toggle()}>
                <Icon 
                    name="bars"
                    color="black"
                    size={25}
                />
            </TouchableWithoutFeedback>
            <Text>{itemSelected}</Text>
            <TouchableWithoutFeedback onPress={() => navigate('Search')}>
            <Icon 
                name="search"
                color="black"
                size={25}
            />
            </TouchableWithoutFeedback>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flexDirection: 'row',
        height: 60,
        alignItems: 'center',
        justifyContent:'space-between',
        backgroundColor: 'white',
        paddingHorizontal: 15,
        paddingTop: 10,
    }
})

export default Header