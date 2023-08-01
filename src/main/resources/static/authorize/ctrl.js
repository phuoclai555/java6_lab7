var app = angular.module("app", []);

// app.config(function ($httpProvider){
//     $httpProvider.defaults.headers.common['Authorization'] = "Basic YWRtaW46MTIz"
// });

app.controller("ctrl", function ($scope,$http) {
    var url="http://localhost:8080/rest/authorities"
    $http.get(url).then(resp => {
        $scope.db = resp.data;
    })

    $scope.index_of = function (username,role){
        return $scope.db.authorities.findIndex(a =>a.account.username == username && a.role.id == role)
    }

    $scope.update = function (username, role){
        var index = $scope.index_of(username, role);
        console.log(index)
        if(index >= 0){
            var id = $scope.db.authorities[index].id;
            $http.delete(`/rest/authorities/${id}`).then(resp =>{
                $scope.db.authorities.splice(index,1)
            })
        }else{
            var authoritiesEntity = {
                account:{username:username},
                role:{id:role}
            }
            console.log(authoritiesEntity)
            $http.post(url,authoritiesEntity).then(resp =>{
                $scope.db.authorities.push(resp.data);
            });
        }
    }
});