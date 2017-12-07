import React, {Component} from 'react'
import {
    Text,
    View,
    StyleSheet,
    Image,
    FlatList,
    TouchableWithoutFeedback
} from 'react-native'

import Orientation from 'react-native-orientation'

class List extends Component {

    componentWillMount() {
        Orientation.lockToPortrait()
    }

    _renderItem(item, isPopular){
        const {navigate} = this.props.navigation
        return (
            <TouchableWithoutFeedback onPress={
                () => navigate('Details', {item: item})}
            >   
                <View>
                    <Image style={isPopular ? styles.popular : styles.all} source={{uri: item.images[0]}}/>
                    <Text style={ [styles.text, isPopular ? {width: 110} : {}] }>{item.name}</Text>
                </View>
            </TouchableWithoutFeedback>
        )
    }

    render(){
        const resPopular = this.props.popularResult
        const res = this.props.result
        return (
            <View style={{flex: 1}}>
                <View>
                    <Text style={styles.textCategory}>50% off</Text>
                    <FlatList
                        horizontal
                        ItemSeparatorComponent={() => <View style={{width: 5}} />}
                        renderItem={({item}) => this._renderItem(item, true)} 
                        data={resPopular}
                        keyExtractor={item => item.id}                        
                    />
                </View>
                <View>
                    <Text style={styles.textCategory}>New year travels</Text>
                    <FlatList
                        ItemSeparatorComponent={() => <View style={{height: 5}} />}
                        renderItem={({item}) => this._renderItem(item, false)} 
                        data={res}
                        keyExtractor={item => item.id}                        
                        
                    />
                </View>
            </View>
        )
    }
}

const styles = StyleSheet.create({
    popular: {
        width: 110,
        height: 170
    },
    all: {
        flex: 1,
        height: 190
    },
    text: {
        color: 'black',        
        margin: 2,
        fontSize: 12
    },
    textCategory: {
        color: 'black',
        marginVertical: 3,
        fontSize: 18
    }
})

export default List