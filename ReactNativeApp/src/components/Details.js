import React, {Component} from 'react'
import {
    View,
    Text,
    StyleSheet,
    TouchableWithoutFeedback,    
    Image
} from 'react-native'

export class Details extends Component {
    render(){
        const {goBack} = this.props.navigation        
        return (
            <TouchableWithoutFeedback  onPress={() => goBack()}>
            <View style={{flex: 1}}>
                <Text style={styles.cancelButtonText}>Cancel</Text>
            </View>
            </TouchableWithoutFeedback>
        
        )
    }
}

const styles = StyleSheet.create({
    cancelButtonText: {
        marginRight: 10,
        color: 'black'
    }
})

export default Details