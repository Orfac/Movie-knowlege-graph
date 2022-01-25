<template>
  <div class="sidebar-page ml-5">
    <aside class="menu">
      <p class="menu-label">
        Меню
      </p>
      <ul class="menu-list">
        <menu-item to="/">Стартовая страница</menu-item>
        <menu-item to="/all">Показать весь граф</menu-item>
        <menu-item to="/prefs">Настроить предпочтения</menu-item>
        <menu-item to="/recs">Персональные рекомендации</menu-item>
        <li>
          <ul>
            <menu-item to="/newuser">Создать пользователя</menu-item>
            <menu-item to="/newmovie">Создать фильм</menu-item>
          </ul>
        </li>
      </ul>
    </aside>
  </div>
</template>

<script>
import MenuItem from "@/components/MenuItem";

export default {
  name: "Menu",
  components: {MenuItem}
}
</script>

<style scoped>

</style>