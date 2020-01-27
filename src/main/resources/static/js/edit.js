$(document).on("click", ".edit-user", function (event) {
    var tr = $(event.target).closest('tr');
    console.log($(tr).find('td[name="id"]').html());
    $('#user-id').val($(tr).find('td[name="id"]').html());
    console.log($(tr).find('td[name="name"]').html());
    $('#user-name').val($(tr).find('td[name="name"]').html());
    console.log($(tr).find('td[name="age"]').html());
    $('#user-age').val($(tr).find('td[name="age"]').html());
    $('#create-user').hide();
    $('#update-user').show();
    $('#modal').show();
});