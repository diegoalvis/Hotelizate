import React, {Component} from 'react'
import {
    Text,
    View,
    Image,
    StyleSheet,
    FlatList
} from 'react-native'

const first_list = [
    {
        "key": 1,
        "name": "Kiera Stracke V",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/wake_gs/128.jpg"
    },
    {
        "key": 2,
        "name": "Coy Predovic",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/ky/128.jpg"
    },
    {
        "key": 3,
        "name": "Guiseppe Jaskolski Sr.",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/kolage/128.jpg"
    },
    {
        "key": 4,
        "name": "Guiseppe Jaskolski Sr.",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/dingyi/128.jpg"
    },
    {
        "key": 5,
        "name": "Lorena Macejkovic PhD",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/saarabpreet/128.jpg"
    },
    {
        "key": 6,
        "name": "Jerel Bechtelar",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/jordyvdboom/128.jpg"
    },
    {
        "key": 7,
        "name": "Mariano Beer",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/karolkrakowiak_/128.jpg"
    },
    {
        "key": 8,
        "name": "Jaleel Beier",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/wegotvices/128.jpg"
    },
    {
        "key": 9,
        "name": "Dortha Franecki",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/elliotnolten/128.jpg"
    }
] 
    
const second_list = [
    {
        "key": 1,
        "name": "Kiera Stracke V",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/wake_gs/128.jpg"
    },
    {
        "key": 2,
        "name": "Coy Predovic",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/ky/128.jpg"
    },
    {
        "key": 3,
        "name": "Noe Doyle",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/the_winslet/128.jpg"
    },
    {
        "key": 4,
        "name": "Forrest McKenzie",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/vm_f/128.jpg"
    },
    {
        "key": 5,
        "name": "Lorena Macejkovic PhD",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/saarabpreet/128.jpg"
    },
    {
        "key": 6,
        "name": "Jerel Bechtelar",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/jordyvdboom/128.jpg"
    },
    {
        "key": 7,
        "name": "Mariano Beer",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/karolkrakowiak_/128.jpg"
    },
    {
        "key": 8,
        "name": "Jaleel Beier",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/wegotvices/128.jpg"
    },
    {
        "key": 9,
        "name": "Dortha Franecki",
        "image": "https://s3.amazonaws.com/uifaces/faces/twitter/elliotnolten/128.jpg"
    }
]

class List extends Component {

    _renderItem(item, isPopular) {
        return (
            <Image style={isPopular ? styles.popular : styles.all} source={{uri: item.image}} />
         )
    }
    
    
    render() {
        return (
            <View style ={{flex: 1}}>
                <Text style={styles.text}>My list</Text>
                <FlatList 
                    horizontal
                    ItemSeparatorComponent={() => <View style={{width: 5}} />}
                    renderItem = {({item}) => this._renderItem(item, true) }
                    data = {first_list}
                />
                <Text style={styles.text}>My list</Text>
                <FlatList 
                    ItemSeparatorComponent={() => <View style={{height: 5}} />}
                    renderItem = {({item}) => this._renderItem(item, false) }
                    data = {second_list}
                />
            </View>
        )
    }
}

const styles = StyleSheet.create({
    
      popular: {
        width: 100,
        height: 180,
        backgroundColor: 'green'
      },
      all: {
        flex: 1,
        height: 150
      },
      text: {
          color: 'white'
      }
    }
)

export default List