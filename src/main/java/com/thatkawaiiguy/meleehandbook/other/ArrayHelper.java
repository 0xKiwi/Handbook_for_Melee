package com.thatkawaiiguy.meleehandbook.other;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;

import com.thatkawaiiguy.meleehandbook.R;

public class ArrayHelper {

    public static String[] getCharacterArray() {
        return new String[]{"Bowser", "Captain Falcon", "Donkey Kong", "Dr. Mario",
                "Falco", "Fox", "Ganondorf", "Ice Climbers", "Jigglypuff", "Kirby", "Link",
                "Luigi", "Mario", "Marth", "Mewtwo", "Mr. Game & Watch", "Ness", "Pichu",
                "Pikachu", "Princess Peach", "Princess Zelda", "Roy", "Samus Aran", "Sheik",
                "Yoshi", "Young Link"};
    }

    public static String[] getMapArray() {
        return new String[]{"Battlefield", "Dream Land", "Final Destination",
                "Fountain of Dreams", "Kongo Jungle (SSB)", "Pokemon Stadium", "Yoshi's Story"};
    }

    public static String[] getFunArray() {
        return new String[]{"Baiting", "Common errors", "Control", "Edge guarding",
                "Improving", "Mindgames", "Mindset", "Mix-ups", "Must reads",
                "Neutral game", "Pressuring", "Punishing", "Reading", "Recovery",
                "Spacing", "Tech skill", "Tournament ruleset", "Various tips"};
    }

    public static String[] getTechArray() {
        return new String[]{"Aerial interrupt", "Chain grab", "Crouch cancel", "Dash-canceling", "Dash-dance",
                "Directional Influence", "Fast falling", "Fox-trot",
                "Jab cancel", "Jab reset", "Jump-canceling", "L-canceling",
                "Ledge-canceling", "Ledgedash", "Ledge stall", "Moonwalk",
                "No-impact landing", "Platform cancel", "Platform warp",
                "Powershield", "Shield pressure", "Shield dropping",
                "SHFFL", "Short hop", "Taunt canceling", "Team wobble", "Tech",
                "Tech-chasing", "Wall jump", "Wavedash", "V-canceling"};
    }

    public static String[] getTermArray() {
        return new String[]{"20XX", "Air dodge", "Banned stage", "Beef", "Blastzone",
                "Boost grab", "Brackets", "Buff", "BYOC", "Camera box", "Cancel", "Cave of life",
                "Clone", "Counter", "Counterpick", "Crew battle", "Dave's stupid rule",
                "Dashing",  "Dash-grab", "Disjointed hitbox", "Disrespect",
                "Ditto", "Dong", "Doubles", "Easy money", "ECB", "Edge guarding",
                "Edge hogging", "Frame", "Freeze frames", "Friendlies", "Helpless", "Gimp", "God",
                "Go to the doctor", "Grab", "Hitbox", "Hitlag", "Hitstun", "Helicopter crash",
                "IASA frames", "Infinite", "Input lag", "Invisible ceiling", "Ironman", "It's not safe",
                "Janky", "Johns", "Jump cancel", "Jump canceled grab", "Juggling",
                "JV3/JV4 stock", "Kappa", "Ken combo", "Kreygasm", "Lag",
                "Landing lag", "Lean drop", "Legalize PokeFloats", "Mangle", "Mashedpotato Samurai",
                "Matchups", "Meteor", "Meteor cancel",
                "Metagame", "Mike Haze", "Mindgames", "Misfire", "My b", "Nerf", "Neutral game",
                "OOS", "Overpowered", "PC drop", "Phantom hit", "Pivot","Pop-off", "Port priority",
                "Priority", "Pummel", "Punish", "Randall the Cloud", "Recovery", "Respect your elders", "RNG",
                "Rolling", "Salty", "Salty runback", "Scar jump", "Screen KO", "Self-destruct",
                "Semiclone", "Set", "Sex kick", "Shieldhitstun", "Shielding", "Shieldstun", "Shield break",
                "Shield grabbing", "Shine/Reflector", "Sidestepping", "Singles", "Smash attacks", "Smash inflation",
                "Smashfest", "Sourspot", "Space animal", "Spike", "Stage humping", "Stage spike",
                "Stale moves", "Star KO", "Stitch", "Stomp", "Style", "Sweetspot attack", "Sweetspot ledge",
                "TAS", "Tech trap", "The king is back",
                "The knee", "The Zhu", "Tier list", "Tilts", "Tires don exits", "Tomahawk","Tourney", "Trade-off",
                "Triangle jumping", "Turnaround special", "Walking", "Walk-off edges", "Wall of pain", "Wavecheat",
                "Wombo combo", "Zoning"};
    }

    public static String[] getUniqueArray() {
        return new String[]{"Boomerang superjump", "Desynching", "Double jump cancel",
                "DJC counter", "Double jump refresh",  "Extended & homing grapple",
                "Edge canceled eggs", "Float cancel", "Ledgehop double laser",
                "Multishine", "Parry", "Pillaring", "RI grapple cancel",
                "Reverse angle boomerang", "Rising pound", "Short hop laser", "SHFF missiles",
                "Side-B shorten", "Super wavedash & SDWD", "Vududash",
                "Up-B cancel", "Up-B turnaround", "Wallbombing",
                "Wavelanded laser", "Waveshine", "Wobbling", "Yo-yo glitch"};
    }

    public static String[] getLCCharacterArray() {
        String[] array = getCharacterArray();

        for(int i = 0; i < array.length; i++)
            array[i] = array[i].toLowerCase();

        return array;
    }

    public static String[] getLCFunArray() {
        String[] array = getFunArray();

        for(int i = 0; i < array.length; i++)
            array[i] = array[i].toLowerCase();

        return array;
    }

    public static String[] getLCMapArray() {
        String[] array = getMapArray();

        for(int i = 0; i < array.length; i++)
            array[i] = array[i].toLowerCase();

        return array;
    }

    public static String[] getLCTechArray() {
        String[] array = getTechArray();

        for(int i = 0; i < array.length; i++)
            array[i] = array[i].toLowerCase();

        return array;
    }

    public static String[] getLCUniqueArray() {
        String[] array = getUniqueArray();

        for(int i = 0; i < array.length; i++)
            array[i] = array[i].toLowerCase();

        return array;
    }

    public static String[] getLCTermArray() {
        String[] array = getTermArray();

        for(int i = 0; i < array.length; i++)
            array[i] = array[i].toLowerCase();

        return array;
    }

    public static String getTermInfoString(String text, Context context){
        Resources res = context.getResources();
        switch(text){
            case "20XX":
                return res.getString(R.string.xx_term_info);
            case "Air dodge":
                return res.getString(R.string.airdodge_term_info);
            case "Banned stage":
                return res.getString(R.string.bannedstage_term_info);
            case "Beef":
                return res.getString(R.string.beef_term_info);
            case "Blastzone":
                return res.getString(R.string.blastzone_term_info);
            case "Boost grab":
                return res.getString(R.string.boostgrab_term_info);
            case "Brackets":
                return res.getString(R.string.bracket_term_info);
            case "Buff":
                return res.getString(R.string.buff_term_info);
            case "BYOC":
                return res.getString(R.string.byoc_term_info);
            case "Camera box":
                return res.getString(R.string.cbox_term_info);
            case "Cave of life":
                return res.getString(R.string.col_term_info);
            case "Clone":
                return res.getString(R.string.clone_term_info);
            case "Cancel":
                return res.getString(R.string.cancel_term_info);
            case "Counter":
                return res.getString(R.string.counter_term_info);
            case "Counterpick":
                return res.getString(R.string.counterpick_term_info);
            case "Crew battle":
                return  res.getString(R.string.crewbattle_term_info);
            case "Dashing":
                return res.getString(R.string.dash_term_info);
            case "Dash-grab":
                return res.getString(R.string.dashgrab_term_info);
            case "Dave's stupid rule":
                return res.getString(R.string.dave_term_info);
            case "Disjointed hitbox":
                return res.getString(R.string.disjointedhb_term_info);
            case "Disrespect":
                return res.getString(R.string.disrespect_term_info);
            case "Ditto":
                return res.getString(R.string.ditto_term_info);
            case "Dong":
                return res.getString(R.string.dong_term_info);
            case "Doubles":
                return res.getString(R.string.doubles_term_info);
            case "Easy money":
                return res.getString(R.string.easymoney_term_info);
            case "ECB":
                return res.getString(R.string.ecb_term_info);
            case "Edge hogging":
                return res.getString(R.string.edgehog_term_info);
            case "Edge guarding":
                return res.getString(R.string.edgeguard_term_info);
            case "Freeze frames":
                return res.getString(R.string.freezeframe_term_info);
            case "Friendlies":
                return res.getString(R.string.friendlies_term_info);
            case "Frame":
                return res.getString(R.string.frame_term_info);
            case "Gimp":
                return res.getString(R.string.gimp_term_info);
            case "Grab":
                return res.getString(R.string.grab_term_info);
            case "God":
                return res.getString(R.string.god_term_info);
            case "Go to the doctor":
                return res.getString(R.string.gotothedoctor_term_info);
            case "Helpless":
                return res.getString(R.string.helpless_term_info);
            case "Hitlag":
                return res.getString(R.string.hitlag_term_info);
            case "Helicopter crash":
                return res.getString(R.string.helicrash_term_info);
            case "Hitbox":
                return res.getString(R.string.hitbox_term_info);
            case "Hitstun":
                return res.getString(R.string.hitstun_term_info);
            case "IASA frames":
                return res.getString(R.string.iasa_term_info);
            case "Infinite":
                return res.getString(R.string.infinite_term_info);
            case "Invisible ceiling":
                return res.getString(R.string.invisibleceil_term_info);
            case "Input lag":
                return res.getString(R.string.ilag_term_info);
            case "Ironman":
                return  res.getString(R.string.ironman_term_info);
            case "It's not safe":
                return  res.getString(R.string.itsnotsafe_term_info);
            case "Janky":
                return res.getString(R.string.janky_term_info);
            case "Johns":
                return res.getString(R.string.john_term_info);
            case "Juggling":
                return res.getString(R.string.juggling_term_info);
            case "Jump cancel":
                return res.getString(R.string.jcancel_term_info);
            case "Jump canceled grab":
                return res.getString(R.string.jcgrab_term_info);
            case "JV3/JV4 stock":
                return res.getString(R.string.jv3stock_term_info);
            case "Kappa":
                return res.getString(R.string.kappa_term_info);
            case "Ken combo":
                return res.getString(R.string.ken_term_info);
            case "Kreygasm":
                return res.getString(R.string.kreygasm_term_info);
            case "Lag":
                return res.getString(R.string.lag_term_info);
            case "Landing lag":
                return res.getString(R.string.landlag_term_info);
            case "Lean drop":
                return res.getString(R.string.leandrop_term_info);
            case "Legalize PokeFloats":
                return res.getString(R.string.legalizepoke_term_info);
            case "Mashedpotato Samurai":
                return res.getString(R.string.mashedpotato_term_info);
            case "Matchups":
                return res.getString(R.string.matchups_term_info);
            case "Mangle":
                return res.getString(R.string.mangle_term_info);
            case "Meteor":
                return res.getString(R.string.meteor_term_info);
            case "Meteor cancel":
                return res.getString(R.string.meteorcancel_term_info);
            case "Metagame":
                return res.getString(R.string.metagame_info_text);
            case "Mindgames":
                return res.getString(R.string.mindgames_term_info);
            case "Mike Haze":
                return res.getString(R.string.mikehaze_term_info);
            case "Misfire":
                return res.getString(R.string.misfire_term_info);
            case "My b":
                return res.getString(R.string.myb_term_info);
            case "Nerf":
                return res.getString(R.string.nerf_term_info);
            case "Neutral game":
                return res.getString(R.string.neutralgame_term_info);
            case "Overpowered":
                return res.getString(R.string.op_term_info);
            case "OOS":
                return res.getString(R.string.oos_term_info);
            case "PC drop":
                return res.getString(R.string.pcdrop_term_info);
            case "Phantom hit":
                return res.getString(R.string.phit_term_info);
            case "Pivot":
                return res.getString(R.string.pivot_term_info);
            case "Pop-off":
                return res.getString(R.string.popoff_term_info);
            case "Port priority":
                return res.getString(R.string.ppriority_term_info);
            case "Priority":
                return res.getString(R.string.priority_term_info);
            case "Pummel":
                return res.getString(R.string.pummel_term_info);
            case "Punish":
                return res.getString(R.string.punish_term_info);
            case "Randall the Cloud":
                return res.getString(R.string.randall_term_info);
            case "Recovery":
                return res.getString(R.string.recovery_term_info);
            case "Respect your elders":
                return res.getString(R.string.respect_term_info);
            case "RNG":
                return res.getString(R.string.rng_term_info);
            case "Rolling":
                return res.getString(R.string.roll_term_info);
            case "Salty":
                return res.getString(R.string.salty_term_info);
            case "Salty runback":
                return res.getString(R.string.saltyrun_term_info);
            case "Scar jump":
                return res.getString(R.string.scarjump_term_info);
            case "Screen KO":
                return res.getString(R.string.screenko_term_info);
            case "Self-destruct":
                return res.getString(R.string.selfdestruct_term_info);
            case "Semiclone":
                return res.getString(R.string.semiclone_term_info);
            case "Set":
                return res.getString(R.string.set_term_info);
            case "Sex kick":
                return res.getString(R.string.skick_term_info);
            case "Shield break":
                return res.getString(R.string.shieldbreak_info_text);
            case "Shieldhitstun":
                return res.getString(R.string.shieldhitstun_term_info);
            case "Shielding":
                return res.getString(R.string.shield_term_info);
            case "Shieldstun":
                return res.getString(R.string.shieldstun_term_info);
            case "Shield grabbing":
                return res.getString(R.string.shieldgrab_term_info);
            case "Shine/Reflector":
                return res.getString(R.string.shine_term_info);
            case "Sidestepping":
                return res.getString(R.string.sidestep_term_info);
            case "Singles":
                return res.getString(R.string.singles_term_info);
            case "Smash attacks":
                return res.getString(R.string.smattacks_term_info);
            case "Smash inflation":
                return res.getString(R.string.smashinflation_term_info);
            case "Smashfest":
                return res.getString(R.string.smfest_term_info);
            case "Sourspot":
                return res.getString(R.string.sour_term_info);
            case "Space animal":
                return res.getString(R.string.spaceanim_term_info);
            case "Spike":
                return res.getString(R.string.spike_term_info);
            case "Stage humping":
                return res.getString(R.string.stagehump_term_info);
            case "Stage spike":
                return res.getString(R.string.stagespike_term_info);
            case "Stale moves":
                return res.getString(R.string.stale_term_info);
            case "Star KO":
                return res.getString(R.string.starko_term_info);
            case "Stitch":
                return res.getString(R.string.stitch_term_info);
            case "Stomp":
                return res.getString(R.string.stomp_term_info);
            case "Style":
                return res.getString(R.string.style_term_info);
            case "Sweetspot attack":
                return res.getString(R.string.sweetattack_term_info);
            case "Sweetspot ledge":
                return res.getString(R.string.sweetledge_term_info);
            case "TAS":
                return res.getString(R.string.tas_term_info);
            case "Tech trap":
                return res.getString(R.string.techtrap_term_info);
            case "The king is back":
                return res.getString(R.string.theking_term_info);
            case "The knee":
                return res.getString(R.string.knee_term_info);
            case "The Zhu":
                return res.getString(R.string.thezhu_term_info);
            case "Tier list":
                return res.getString(R.string.tiers_term_info);
            case "Tilts":
                return res.getString(R.string.tilts_term_info);
            case "Tires don exits":
                return res.getString(R.string.tiresdonexits_term_info);
            case "Tomahawk":
                return res.getString(R.string.tomahawk_term_info);
            case "Tourney":
                return res.getString(R.string.tourney_term_info);
            case "Traction":
                return res.getString(R.string.traction_term_info);
            case "Trade-off":
                return res.getString(R.string.tradeoff_term_info);
            case "Triangle jumping":
                return res.getString(R.string.triangle_term_info);
            case "Turnaround special":
                return res.getString(R.string.turnaroundspec_term_info);
            case "Walking":
                return res.getString(R.string.walk_term_info);
            case "Walk-off edges":
                return res.getString(R.string.walkoff_term_info);
            case "Wall of pain":
                return res.getString(R.string.wop_term_info);
            case "Wavecheat":
                return res.getString(R.string.wavecheat_term_info);
            case "Wombo combo":
                return res.getString(R.string.wombo_term_info);
            case "Zoning":
                return res.getString(R.string.zoning_term_info);
            default:
                return res.getString(R.string.debug_text);
        }
    }

    public static String getInfoString(String text, Context context) {
        Resources res = context.getResources();
        switch(text) {
            //TECH
            case "Aerial interrupt":
                return res.getString(R.string.aerialinterrupt_info_text);
            case "Chain grab":
                return res.getString(R.string.chaing_info_text);
            case "Crouch cancel":
                return res.getString(R.string.crouchcancel_info_text);
            case "Dash-canceling":
                return res.getString(R.string.dashcancel_info_text);
            case "Dash-dance":
                return res.getString(R.string.ddance_info_text);
            case "DI angles":
                return res.getString(R.string.diangles_info_text);
            case "Directional Influence":
                return res.getString(R.string.di_info_text);
            case "Fast falling":
                return res.getString(R.string.ffall_info_text);
            case "Fox-trot":
                return res.getString(R.string.ftrot_info_text);
            case "Jab cancel":
                return res.getString(R.string.jabcancel_info_text);
            case "Jab reset":
                return res.getString(R.string.jabreset_info_text);
            case "Jump-canceling":
                return res.getString(R.string.jumpcancel_info_text);
            case "L-canceling":
                return res.getString(R.string.lcancel_info_text);
            case "Ledgedash":
                return res.getString(R.string.ledgedash_info_text);
            case "Ledge stall":
                return res.getString(R.string.ledgestall_info_text);
            case "Ledge-canceling":
                return res.getString(R.string.ledgecancel_info_text);
            case "Moonwalk":
                return res.getString(R.string.moonwalk_info_text);
            case "No-impact landing":
                return res.getString(R.string.noimpact_info_text);
            case "Platform cancel":
                return res.getString(R.string.platformcancel_info_text);
            case "Platform warp":
                return res.getString(R.string.platformwarp_info_text);
            case "Powershield":
                return res.getString(R.string.pshield_info_text);
            case "Shield pressure":
                return res.getString(R.string.shieldpress_info_text);
            case "Shield dropping":
                return res.getString(R.string.shielddrop_info_text);
            case "SHFFL":
                return res.getString(R.string.shffl_info_text);
            case "Short hop":
                return res.getString(R.string.shop_info_text);
            case "Smash DI":
                return res.getString(R.string.sdi_info_text);
            case "Tech":
                return res.getString(R.string.tech_info_text);
            case "Tech-chasing":
                return res.getString(R.string.techchase_info_text);
            case "Taunt canceling":
                return res.getString(R.string.tcancel_info_text);
            case "Team wobble":
                return res.getString(R.string.twobble_info_text);
            case "Wall jump":
                return res.getString(R.string.walljump_info_text);
            case "Wavedash":
                return res.getString(R.string.wavedash_info_text);
            case "V-canceling":
                return res.getString(R.string.vcancel_info_text);

            //UNIQUE
            case "Boomerang superjump":
                return res.getString(R.string.boomjump_info_text);
            case "Desynching":
                return res.getString(R.string.desync_info_text);
            case "Double jump cancel":
                return res.getString(R.string.djc_info_text);
            case "Double jump refresh":
                return res.getString(R.string.doublejump_info_text);
            case "DJC counter":
                return res.getString(R.string.djcc_info_text);
            case "Extended & homing grapple":
                return res.getString(R.string.egrapple_info_text);
            case "Edge canceled eggs":
                return res.getString(R.string.edgecanceleggs_info_text);
            case "Float cancel":
                return res.getString(R.string.fcancel_info_text);
            case "Ledgehop double laser":
                return res.getString(R.string.lhdl_info_text);
            case "Multishine":
                return res.getString(R.string.multishine_info_text);
            case "Parry":
                return res.getString(R.string.parry_info_text);
            case "Pillaring":
                return res.getString(R.string.pillar_info_text);
            case "Reverse angle boomerang":
                return res.getString(R.string.revangle_info_text);
            case "Rising pound":
                return res.getString(R.string.risingpound_info_text);
            case "RI grapple cancel":
                return res.getString(R.string.rigcancel_info_text);
            case "SHFF missiles":
                return res.getString(R.string.shffmissile_info_text);
            case "Short hop laser":
                return res.getString(R.string.shl_info_text);
            case "Side-B shorten":
                return res.getString(R.string.sidebshorten_info_text);
            case "Super wavedash & SDWD":
                return res.getString(R.string.swd_info_text);
            case "Vududash":
                return res.getString(R.string.vududash_info_text);
            case "Up-B cancel":
                return res.getString(R.string.upbcancel_info_text);
            case "Up-B turnaround":
                return res.getString(R.string.upbturn_info_text);
            case "Wallbombing":
                return res.getString(R.string.wallbomb_info_text);
            case "Wavelanded laser":
                return res.getString(R.string.wavelandedl_info_text);
            case "Waveshine":
                return res.getString(R.string.waveshine_info_text);
            case "Wobbling":
                return res.getString(R.string.wobbling_info_text);
            case "Yo-yo glitch":
                return res.getString(R.string.yoyo_info_text);

            //CHARACTERS
            case "Bowser":
                return res.getString(R.string.bowser_info_text);
            case "Captain Falcon":
                return res.getString(R.string.falcon_info_text);
            case "Donkey Kong":
                return res.getString(R.string.dong_info_text);
            case "Dr. Mario":
                return res.getString(R.string.drmario_info_text);
            case "Falco":
                return res.getString(R.string.falco_info_text);
            case "Fox":
                return res.getString(R.string.fox_info_text);
            case "Ganondorf":
                return res.getString(R.string.ganon_info_text);
            case "Ice Climbers":
                return res.getString(R.string.iceclimbers_info_text);
            case "Jigglypuff":
                return res.getString(R.string.jiggs_info_text);
            case "Kirby":
                return res.getString(R.string.kirby_info_text);
            case "Link":
                return res.getString(R.string.link_info_text);
            case "Luigi":
                return res.getString(R.string.luigi_info_text);
            case "Mario":
                return res.getString(R.string.mario_info_text);
            case "Marth":
                return res.getString(R.string.marth_info_text);
            case "Mewtwo":
                return res.getString(R.string.mewtwo_info_text);
            case "Mr. Game & Watch":
                return res.getString(R.string.mrgandw_info_text);
            case "Ness":
                return res.getString(R.string.ness_info_text);
            case "Pichu":
                return res.getString(R.string.pichu_info_text);
            case "Pikachu":
                return res.getString(R.string.pikachu_info_text);
            case "Princess Peach":
                return res.getString(R.string.peach_info_text);
            case "Princess Zelda":
                return res.getString(R.string.zelda_info_text);
            case "Roy":
                return res.getString(R.string.roy_info_text);
            case "Samus Aran":
                return res.getString(R.string.samus_info_text);
            case "Sheik":
                return res.getString(R.string.sheik_info_text);
            case "Yoshi":
                return res.getString(R.string.yoshi_info_text);
            case "Young Link":
                return res.getString(R.string.ylink_info_text);

            //MAPS
            case "Battlefield":
                return res.getString(R.string.battlefield_info_text);
            case "Dream Land":
                return res.getString(R.string.dreamland_info_text);
            case "Final Destination":
                return res.getString(R.string.fd_info_text);
            case "Fountain of Dreams":
                return res.getString(R.string.fod_info_text);
            case "Kongo Jungle (SSB)":
                return res.getString(R.string.kongo_info_text);
            case "Pokemon Stadium":
                return res.getString(R.string.pokestadium_info_text);
            case "Yoshi's Story":
                return res.getString(R.string.ystory_info_text);

            //Fundamentals
            case "Baiting":
                return res.getString(R.string.bait_info_text);
            case "Common errors":
                return res.getString(R.string.commonerrors_info_text);
            case "Control":
                return res.getString(R.string.control_info_text);
            case "Edge guarding":
                return res.getString(R.string.edgeguard_info_text);
            case "Improving":
                return res.getString(R.string.improve_info_text);
            case "Mindgames":
                return res.getString(R.string.mindgames_info_text);
            case "Mindset":
                return res.getString(R.string.mindset_info_text);
            case "Mix-ups":
                return res.getString(R.string.mixups_info_text);
            case "Must reads":
                return res.getString(R.string.mustreads_info_text);
            case "Neutral game":
                return res.getString(R.string.neutral_info_text);
            case "Pressuring":
                return res.getString(R.string.pressure_info_text);
            case "Punishing":
                return res.getString(R.string.punish_info_text);
            case "Reading":
                return res.getString(R.string.reading_info_text);
            case "Recovery":
                return res.getString(R.string.recovery_info_text);
            case "Spacing":
                return res.getString(R.string.spacing_info_text);
            case "Tech skill":
                return res.getString(R.string.techskill_info_text);
            case "Various tips":
                return res.getString(R.string.tips_info_text);
            case "Tournament ruleset":
                return res.getString(R.string.tourney_info_text);
            default:
                return res.getString(R.string.debug_text);
        }
    }

    public static String[] getLCCharacterInfoArray(Context context) {
        String[] chars = getCharacterArray();
        String[] charInfo = new String[chars.length];

        for(int i = 0; i < charInfo.length; i++)
            charInfo[i] = getInfoString(chars[i], context).toLowerCase();

        return charInfo;
    }

    public static String[] getLCFunInfoArray(Context context) {
        String[] funs = getFunArray();
        String[] funInfo = new String[funs.length];

        for(int i = 0; i < funInfo.length; i++)
            funInfo[i] = getInfoString(funs[i], context).toLowerCase();

        return funInfo;
    }

    public static String[] getLCMapInfoArray(Context context) {
        String[] maps = getMapArray();
        String[] mapInfo = new String[maps.length];

        for(int i = 0; i < mapInfo.length; i++)
            mapInfo[i] = getInfoString(maps[i], context).toLowerCase();

        return mapInfo;
    }

    public static String[] getTermInfoArray(Context context) {
        String[] terms = getTermArray();
        String[] termInfo = new String[terms.length];

        for(int i = 0; i < termInfo.length; i++)
            termInfo[i] = getTermInfoString(terms[i], context);

        return termInfo;
    }

    public static String[] getLCTermInfoArray(Context context) {
        String[] terms = getTermArray();
        String[] termInfo = new String[terms.length];

        for(int i = 0; i < termInfo.length; i++)
            termInfo[i] = getTermInfoString(terms[i], context).toLowerCase();

        return termInfo;
    }

    public static String[] getLCUniqueInfoArray(Context context) {
        String[] techs = getUniqueArray();
        String[] techInfo = new String[techs.length];

        for(int i = 0; i < techInfo.length; i++)
            techInfo[i] = getInfoString(techs[i], context).toLowerCase();

        return techInfo;
    }

    public static String[] getLCTechInfoArray(Context context) {
        String[] techs = getTechArray();
        String[] techInfo = new String[techs.length];

        for(int i = 0; i < techInfo.length; i++)
            techInfo[i] = getInfoString(techs[i], context).toLowerCase();

        return techInfo;
    }
}